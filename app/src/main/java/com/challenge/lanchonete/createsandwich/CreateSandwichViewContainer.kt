package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.navigator.Navigator
import com.challenge.lanchonete.state.Dispatcher

interface CreateSandwichViewContainer {
    val createSandwichManager: CreateSandwichManager
    val mainDispatcher: Dispatcher
    val navigator: Navigator
}
