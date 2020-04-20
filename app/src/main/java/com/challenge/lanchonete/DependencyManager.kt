package com.challenge.lanchonete

import com.challenge.lanchonete.calculatepromotion.PromotionManager
import com.challenge.lanchonete.createsandwich.CreateSandwichManager
import com.challenge.lanchonete.menu.MenuManager
import com.challenge.lanchonete.state.Dispatcher

interface DependencyManager {
    val mainDispatcher: Dispatcher
    val menuManager: MenuManager
    val createSandwichManager: CreateSandwichManager
    val promotionManager: PromotionManager
}
