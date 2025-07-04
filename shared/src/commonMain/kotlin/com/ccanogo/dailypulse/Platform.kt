package com.ccanogo.dailypulse

//interface Platform { // interface = protocol en 'Swift'
//    val name: String
//}
//
//expect fun getPlatform(): Platform

/**
 * 'expect' le indicamos al compilador de Kotlin que esta implementación debe existir dentro del modulo 'shared' en la carpeta 'androidMain' como en la carpeta 'iosMain'.
 * Solo se puede encontrar esta expecificación en 'commonMain' y solo se puede declarar y no definir su implementación.
 * Por ejemplo una implementación en IA que queremos definir en cómun pero que la implementación se define de forma diferente en cada plataforma en especifico con iOS se utilizaria 'CoreML' y en 'Kit LM'.
 **/

expect class Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}