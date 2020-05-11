package com.challenge.lanchonete

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.challenge.lanchonete.calculatepromotion.PromotionManager
import com.challenge.lanchonete.createsandwich.CreateSandwichManager
import com.challenge.lanchonete.createsandwich.CreateSandwichViewContainer
import com.challenge.lanchonete.menu.MenuManager
import com.challenge.lanchonete.menu.MenuViewContainer
import com.challenge.lanchonete.navigator.LanchoneteNavigator
import com.challenge.lanchonete.navigator.Navigator
import com.challenge.lanchonete.state.Dispatcher

class MainActivity : AppCompatActivity(), MenuViewContainer, CreateSandwichViewContainer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.navigateToMenuView()
        }
    }

    override val mainDispatcher: Dispatcher by lazy {
        (applicationContext as DependencyManager).mainDispatcher
    }

    override val menuManager: MenuManager by lazy {
        (applicationContext as DependencyManager).menuManager
    }

    override val createSandwichManager: CreateSandwichManager by lazy {
        (applicationContext as DependencyManager).createSandwichManager
    }

    override val promotionManager: PromotionManager by lazy {
        (applicationContext as DependencyManager).promotionManager
    }

    override val navigator: Navigator by lazy {
        LanchoneteNavigator(
            supportFragmentManager
        )
    }
}
