package com.challenge.lanchonete.state

class FakeErrorFactory : ErrorFactory {
    override fun create(throwable: Throwable?): Error {
        return FakeError()
    }
}
