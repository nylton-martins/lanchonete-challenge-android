package com.challenge.lanchonete.state

interface StateListener<T> {

    fun onStateUpdate(state: State<T>)
}
