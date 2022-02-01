# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Keep all public and protected class
-keep class com.google.firebase.** { *; }

-keep class org.apache.** { *; }
-keepnames class com.shaded.fasterxml.** { *; }
-keepnames class com.fasterxml.jackson.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }
-dontwarn org.apache.**
-dontwarn org.w3c.dom.**

-keep public class * {
      public protected *;
}

# Hilt
-keep class hilt_aggregated_deps.** { *; }
-keepnames class hilt_aggregated_deps.** { *; }

# Keep class members
-keepclassmembernames class * {
    java.lang.Class class$(java.lang.String);
    java.lang.Class class$(java.lang.String, boolean);
}

# Keep class members and native method
-keepclasseswithmembernames,includedescriptorclasses class * {
    native <methods>;
}

# Keep ENUM
-keepclassmembers,allowoptimization enum * {
    public static **[] values(); public static ** valueOf(java.lang.String);
}

# Keep Serializable classes and members
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
#butterknife
#-keep class butterknife.** { *; }
#-keepnames class * { @butterknife.Bind *;}
#
#-dontwarn butterknife.internal.**
#-keep class **$$ViewBinder { *; }
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <fields>;
#}
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <methods>;
#}
# Support library
-dontwarn android.support.**
-dontwarn android.support.v4.**
-keep class android.support.v4.** { *; }
-keep interface android.support.v4.** { *; }
-dontwarn android.support.v7.**
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }

# support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

# retrofit
-dontwarn okio.**
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

-dontwarn rx.**
-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}

#your package path where your gson models are stored
-keep class com.abona_erp.driverapp.data.model.** { *; }

# Keep these for GSON and Jackson
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes EnclosingMethod
-keep class com.google.gson.** { *; }

#for mail smtp
-keep class org.apache.** { *; }
-dontwarn org.apache.**

-keep class com.sun.mail.** { *; }
-dontwarn com.sun.mail.**

-keep class java.beans.** { *; }
-dontwarn java.beans.**

#keep otto
#-keepattributes *Annotation*
#-keepclassmembers class ** {
#    @com.squareup.otto.Subscribe public *;
#    @com.squareup.otto.Produce public *;
#}

# Crashlitycs 2.+
-keep class com.crashlytics.** { *; }
-keep class com.crashlytics.android.**
-keepattributes SourceFile, LineNumberTable, *Annotation*
# If you are using custom exceptions, add this line so that custom exception types are skipped during obfuscation:
-keep public class * extends java.lang.Exception
# For Fabric to properly de-obfuscate your crash reports, you need to remove this line from your ProGuard config:
# -printmapping mapping.txt

# Picasso
-dontwarn com.squareup.okhttp.**

# Volley
#-keep class com.android.volley.toolbox.ImageLoader { *; }

# OkHttp3
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# Needed for Parcelable/SafeParcelable Creators to not get stripped
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}