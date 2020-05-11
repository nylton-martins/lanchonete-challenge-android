package com.challenge.lanchonete.menu

import com.challenge.lanchonete.navigator.Navigator
import com.challenge.lanchonete.state.Dispatcher

interface MenuViewContainer {
    val menuManager: MenuManager
    val mainDispatcher: Dispatcher
    val navigator: Navigator
}
