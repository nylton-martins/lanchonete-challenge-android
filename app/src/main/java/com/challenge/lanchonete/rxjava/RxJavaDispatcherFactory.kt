package com.challenge.lanchonete.rxjava

import android.os.HandlerThread
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.DispatcherFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class RxJavaDispatcherFactory(
    private val publishScheduler: Scheduler,
    private val retryScheduler: Scheduler
) : DispatcherFactory {
    override fun createSerialDispatcher(name: String): Dispatcher {
        val thread = HandlerThread(name)
        thread.start()
        return RxJavaDispatcher(AndroidSchedulers.from(thread.looper), retryScheduler)
    }

    override fun createMainDispatcher(): Dispatcher = RxJavaDispatcher(
        publishScheduler,
        retryScheduler
    )
}
