package com.abona_erp.libs.errorlog

/**
 * Created on 06.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 */
enum class ErrorCategory(cat: Int){
    NA (0),
    UnhandledException ( 10),
    UnhandledThreadException (11),
    AdxException (20),
    HandledException (50),
    HandledError (100),
}