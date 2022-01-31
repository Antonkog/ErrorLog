package com.abona_erp.libs.errorlog

/**
 * Created on 06.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 */
enum class AbonaBuildType(cat: Int){
    NA (0),
    DEBUG (10),
    RELEASE_CANDIDATE (20),
    RELEASE (30),
}