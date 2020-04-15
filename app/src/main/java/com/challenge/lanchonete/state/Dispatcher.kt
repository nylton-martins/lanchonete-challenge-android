package com.challenge.lanchonete.state

interface Dispatcher {
    fun dispatch(execute: () -> Unit, error: (Throwable) -> Unit)
    fun dispatch(execute: () -> Unit)
    fun cancelAll()
    fun dispatchRetry(
        execute: () -> Unit,
        retryTime: Long,
        beforeRetry: (Throwable) -> Unit,
        afterRetry: (Throwable) -> Unit
    )
}
