package com.challenge.lanchonete.state

import java.util.concurrent.CopyOnWriteArrayList

abstract class StateMachine<T>(
    private val errorFactory: ErrorFactory,
    protected var currentState: State<T>,
    private val listeners: MutableList<StateListener<T>> = CopyOnWriteArrayList()
) {

    fun registerListener(listener: StateListener<T>) {
        this.listeners.add(listener)
        listener.onStateUpdate(currentState)
    }

    fun unregisterListener(listener: StateListener<T>) {
        this.listeners.remove(listener)
    }

    fun moveToLoading(value: T? = null) {
        updateState(State(State.Name.LOADING, value ?: currentState.value, null))
    }

    fun moveToLoaded(value: T? = null) {
        updateState(State(State.Name.LOADED, value ?: currentState.value, null))
    }

    fun moveToError(error: Throwable?) {
        updateState(State(State.Name.ERROR, currentState.value, errorFactory.create(error)))
    }

    fun moveToError(error: Error) {
        updateState(State(State.Name.ERROR, currentState.value, error))
    }

    fun moveToIdle(value: T? = currentState.value) {
        updateState(State(State.Name.IDLE, value, null))
    }

    fun moveToCurrent() {
        updateState(currentState)
    }

    private fun updateState(state: State<T>) {
        currentState = state

        for (listener in this.listeners) {
            listener.onStateUpdate(currentState)
        }
    }
}
