package com.challenge.lanchonete.rxjava

import com.challenge.lanchonete.state.Dispatcher
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class RxJavaDispatcher(
    private val scheduler: Scheduler,
    private val retryScheduler: Scheduler,
    private val disposable: CompositeDisposable = CompositeDisposable()
) : Dispatcher {

    override fun dispatch(execute: () -> Unit, error: (Throwable) -> Unit) {
        disposable.add(
            Completable.fromCallable(execute)
                .subscribeOn(scheduler)
                .subscribe({}, error)
        )
    }

    override fun dispatch(execute: () -> Unit) {
        dispatch(execute, {})
    }

    override fun cancelAll() {
        disposable.clear()
    }

    override fun dispatchRetry(
        execute: () -> Unit,
        retryTime: Long,
        beforeRetry: (Throwable) -> Unit,
        afterRetry: (Throwable) -> Unit
    ) {
        disposable.add(
            Completable.fromCallable(execute)
                .retryWhen { errors ->
                    errors
                        .doOnNext(beforeRetry)
                        .delay(retryTime, TimeUnit.SECONDS, retryScheduler)
                        .observeOn(scheduler)
                        .doOnNext(afterRetry)
                }
                .subscribeOn(scheduler)
                .subscribe({}, {})
        )
    }
}
