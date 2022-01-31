package com.abona_erp.libs.errorlog

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteException
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import kotlin.system.exitProcess


/**
 * Created on 17.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 *      const val RESET_DB_EXTRAS = "resetDBExtra" in in
 *      this extra will exist if last exception is from sqlite
 * @param activityClass: main activity to start from intent
 */
class ExceptionHandler(
    val context: Context,
    val activityClass: Class<*>?,
    val defaultLogSettings: ErrorLog?,
    val client: OkHttpClient,
    val gson: Gson
) : Thread.UncaughtExceptionHandler {

    data class Builder(
        var context: Context,
        var cls: Class<*>? = null,
        var defaultLog: ErrorLog? = null,
        var client: OkHttpClient? = null,
        var gson: Gson? = null
    ) {
        fun okHttpClient(okClient: OkHttpClient) = apply { this.client = okClient }
        fun defaultLog(log: ErrorLog) = apply { this.defaultLog = log }
        fun gson(gson: Gson) = apply { this.gson = gson }
        fun activityToRestart(cls: Class<*>) = apply { this.cls = cls }
        fun build() =
            ExceptionHandler(context, cls, defaultLog, client ?: OkHttpClient(), gson ?: Gson())
    }

    fun setThread(t: Thread) {
        try {
            t.uncaughtExceptionHandler = this
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }


    suspend fun sendLastError() = getLastSavedError()?.let {
        sendException(it)
    }


    private fun getLastSavedError(): ErrorLog? {
        val sharedPref = context.getSharedPreferences(PREFERENCES, MODE_PRIVATE)
        val sent = sharedPref.getBoolean(KEY_SENT, false)
        if (!sent) {
            return try {
                gson.fromJson(sharedPref.getString(KEY_ERROR, null), ErrorLog::class.java)
            } catch (je: JsonSyntaxException) {
                Log.e(TAG, "last error was saved with error: $je")
                return null
            }
        } else {
            Log.e(TAG, "last error already sent")
        }
        return null
    }

    private fun getWithDefaultSettings(e: Throwable) = defaultLogSettings ?: ErrorLog().copy(
        exceptionErrorName = e.javaClass.name,
        exceptionErrorMessage = e.message,
        exceptionSource = e.javaClass.canonicalName,
        exceptionStackTrace = e.stackTraceToString(),
        exceptionDetailErrorMessage = e.cause?.message,
        lineOfCode = e.stackTrace[0].lineNumber,
        fileName = e.stackTrace[0].fileName,
        formName = e.stackTrace[0].methodName
    )

    private fun saveError(errorToSend: ErrorLog?) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(PREFERENCES, MODE_PRIVATE).edit()
        editor.putString(KEY_ERROR, gson.toJson(errorToSend))
        editor.putBoolean(KEY_SENT, false)
        editor.commit()
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        saveError(getWithDefaultSettings(e))
        activityClass?.let {
            restartApp(e, context, activityClass)
        } ?: kotlin.run {
            Log.d(TAG, "error saved, activity to restart not found")
        }
    }

    suspend fun sendException(e: ErrorLog): Result<ResponseBody?> {
        val mime: MediaType? = "application/json; charset=utf-8".toMediaTypeOrNull()
        val json = gson.toJson(e)
        val body: RequestBody = json.toRequestBody(mime)

        val request: Request = Request.Builder()
            .url(endpointUrl + suffix)
            .post(body)
            .build()

        val call: Call = client.newCall(request)
        return try {
            val responseBody = call.execute().body
            Log.e("ExceptionHandler", responseBody?.string() ?: "no response body: $responseBody")
            Result.success(responseBody)
        } catch (e: IOException) {
            Log.e("ExceptionHandler io", e.message ?: e.stackTraceToString())
            Result.failure(e)
        } catch (e: Exception) {
            Log.e("ExceptionHandler e", e.message ?: e.stackTraceToString())
            Result.failure(e)
        }
    }

    private fun restartApp(e: Throwable, context: Context, cls: Class<*>) {
        val i = Intent(context, cls)
        if (e is SQLiteException) {
            i.putExtra(RESET_DB_EXTRAS, true)
        }
        context.startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
        exitProcess(2)
    }

    companion object {
        const val TAG = "ExceptionHandler"
        const val RESET_DB_EXTRAS = "resetDB"
        const val PREFERENCES = "error_log_pref"
        const val KEY_ERROR = "unsent_error"
        const val KEY_SENT = "sent"
        const val endpointUrl = "https://api.abona-erp.com"
        const val EXCEPTION_SERVICE_ID: String = "86082f5d-dda6-4887-a4aa-43ec90dafb7a"
        const val suffix = "/api/service/logging/savelog?serviceId=$EXCEPTION_SERVICE_ID"
        //https://api.abona-erp.com/api/service/logging/savelog?serviceId=86082f5d-dda6-4887-a4aa-43ec90dafb7a
    }
}