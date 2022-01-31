package com.abona_erp.libs.errorlog

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created on 06.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 */
@kotlinx.parcelize.Parcelize
data class ErrorLog(
    @SerializedName("AppName")
    var appName //replaced by ServiceApp.AppName while saving
    : String?,
    @SerializedName("AppVersion")
    var appVersion: String?,
    @SerializedName("AppVersionInt")
    var appVersionInt: Int = 0,
    @SerializedName("ClientName")
    var clientName: String?,
    @SerializedName("UserInitials")
    var userInitials: String?,//max 6 chars
    @SerializedName("ComputerName")
    var computerName: String?,//replaced by DeviceID
    @SerializedName("SystemUser")
    var systemUser: String?,
    @SerializedName("OperatingSystem")
    var operatingSystem: String?,
    @SerializedName("SystemDomain")
    var systemDomain: String?,
    @SerializedName("IP_Address")
    var ip: String?,
    @SerializedName("IsSendEmail")
    var isSendEmail: Boolean = false,
    @SerializedName("ExceptionSource")
    var exceptionSource: String?,
    @SerializedName("ExceptionErrorName")
    var exceptionErrorName: String?,
    @SerializedName("ExceptionExceptionType")
    var exceptionExceptionType: String?,
    @SerializedName("ExceptionExceptionReflectedType")
    var exceptionExceptionReflectedType: String?,
    @SerializedName("ExceptionErrorMessage")
    var exceptionErrorMessage: String?,
    @SerializedName("ExceptionStackTrace")
    var exceptionStackTrace: String?,
    @SerializedName("ExceptionDetailErrorMessage")
    var exceptionDetailErrorMessage: String?,
    @SerializedName("FormName")
    var formName: String?,
    @SerializedName("FileName")
    var fileName: String?,
    @SerializedName("LineOfCode")
    var lineOfCode: Int = 0,
    @SerializedName("ErrorCategory")
    var errorCategory: ErrorCategory?,
    @SerializedName("ErrorCategoryText")
    var errorCategoryText: String?,
    @SerializedName("BuildType")
    var buildType: AbonaBuildType?,
    @SerializedName("BuildTypeText")
    var buildTypeText: String?,
    @SerializedName("ErrorPriority")
    var errorPriority: ErrorPriority?,
    @SerializedName("ErrorPriorityText")
    var errorPriorityText: String?,
    @SerializedName("AbonaMainCategory")
    var abonaMainCategory: AbonaMainCategories?,
    @SerializedName("AbonaMainCategoryText")
    var abonaMainCategoryText: String?,
    @SerializedName("ServiceAppId")
    var serviceAppId: String,
    @SerializedName("ServiceClientId")
    var serviceClientId: String?,
    @SerializedName("ClientId")
    var clientId: String?
) : Parcelable