package com.ccanogo.dailypulse

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel {

    // Como no tenemos un ambito asincrono en iOS nosotros mismos lo que voy a crear es uno manualmente IO par las peticiones del VM que sea de BD o APIs
    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    // Se pueden añadir nuevas funcionalidades dentro del actual si tener que haber sido 'expect'
    fun clear() {
        scope.cancel()
    }

}