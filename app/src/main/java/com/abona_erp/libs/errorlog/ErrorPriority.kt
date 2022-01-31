package com.abona_erp.libs.errorlog

/**
 * Created on 06.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 */
enum class ErrorPriority(cat: Int){
    NA (0),
    Low (10),
    High (20),
    Critical (30)
}