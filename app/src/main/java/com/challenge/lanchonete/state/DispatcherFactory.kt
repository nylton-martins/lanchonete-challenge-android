package com.challenge.lanchonete.state

interface DispatcherFactory {
    fun createSerialDispatcher(name: String): Dispatcher
    fun createMainDispatcher(): Dispatcher
}
