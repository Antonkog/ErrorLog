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
    : String? = null,
    @SerializedName("AppVersion")
    var appVersion: String? = null,
    @SerializedName("AppVersionInt")
    var appVersionInt: Int = 0,
    @SerializedName("ClientName")
    var clientName: String? = null,
    @SerializedName("UserInitials")
    var userInitials: String? = null,//max 6 chars
    @SerializedName("ComputerName")
    var computerName: String? = null,//replaced by DeviceID
    @SerializedName("SystemUser")
    var systemUser: String? = null,
    @SerializedName("OperatingSystem")
    var operatingSystem: String? = null,
    @SerializedName("SystemDomain")
    var systemDomain: String? = null,
    @SerializedName("IP_Address")
    var ip: String? = null,
    @SerializedName("IsSendEmail")
    var isSendEmail: Boolean = false,
    @SerializedName("ExceptionSource")
    var exceptionSource: String? = null,
    @SerializedName("ExceptionErrorName")
    var exceptionErrorName: String? = null,
    @SerializedName("ExceptionExceptionType")
    var exceptionExceptionType: String? = null,
    @SerializedName("ExceptionExceptionReflectedType")
    var exceptionExceptionReflectedType: String? = null,
    @SerializedName("ExceptionErrorMessage")
    var exceptionErrorMessage: String? = null,
    @SerializedName("ExceptionStackTrace")
    var exceptionStackTrace: String? = null,
    @SerializedName("ExceptionDetailErrorMessage")
    var exceptionDetailErrorMessage: String? = null,
    @SerializedName("FormName")
    var formName: String? = null,
    @SerializedName("FileName")
    var fileName: String? = null,
    @SerializedName("LineOfCode")
    var lineOfCode: Int = 0,
    @SerializedName("ErrorCategory")
    var errorCategory: ErrorCategory? = ErrorCategory.NA,
    @SerializedName("ErrorCategoryText")
    var errorCategoryText: String? = "NA",
    @SerializedName("BuildType")
    var buildType: AbonaBuildType? = AbonaBuildType.RELEASE,
    @SerializedName("BuildTypeText")
    var buildTypeText: String? = "Release",
    @SerializedName("ErrorPriority")
    var errorPriority: ErrorPriority? = ErrorPriority.Critical,
    @SerializedName("ErrorPriorityText")
    var errorPriorityText: String? = "Critical",
    @SerializedName("AbonaMainCategory")
    var abonaMainCategory: AbonaMainCategories? = AbonaMainCategories.Orders,
    @SerializedName("AbonaMainCategoryText")
    var abonaMainCategoryText: String? = "Orders",
    @SerializedName("ServiceAppId")
    var serviceAppId: String? = null,
    @SerializedName("ServiceClientId")
    var serviceClientId: String? = ExceptionHandler.EXCEPTION_SERVICE_ID,
    @SerializedName("ClientId")
    var clientId: String? = null
) : Parcelable