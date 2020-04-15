package com.challenge.lanchonete.state

data class State<T>(val name: Name, val value: T? = null, val error: Error? = null) {
    enum class Name {
        IDLE,
        LOADING,
        LOADED,
        ERROR
    }
}
