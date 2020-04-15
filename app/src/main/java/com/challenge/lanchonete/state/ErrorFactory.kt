package com.challenge.lanchonete.state

interface ErrorFactory {
    fun create(throwable: Throwable?): Error
}
