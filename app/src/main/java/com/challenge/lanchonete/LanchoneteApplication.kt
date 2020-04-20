package com.challenge.lanchonete

import android.app.Application
import com.challenge.lanchonete.createsandwich.CreateSandwichManager
import com.challenge.lanchonete.createsandwich.LanchoneteCreateSandwichManager
import com.challenge.lanchonete.createsandwich.gateway.FakeIngredientsGateway
import com.challenge.lanchonete.menu.LanchoneteMenuManager
import com.challenge.lanchonete.menu.MenuManager
import com.challenge.lanchonete.menu.gateway.FakeMenuGateway
import com.challenge.lanchonete.rxjava.RxJavaDispatcherFactory
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.DispatcherFactory
import com.challenge.lanchonete.state.ErrorFactory
import com.challenge.lanchonete.state.FakeErrorFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LanchoneteApplication : Application(),
    DependencyManager {

    override val mainDispatcher: Dispatcher by lazy {
        dispatcherFactory.createMainDispatcher()
    }

    override val menuManager: MenuManager by lazy {
        LanchoneteMenuManager(
            mainDispatcher,
            FakeMenuGateway(),
            errorFactory
        )
    }

    override val createSandwichManager: CreateSandwichManager by lazy {
        LanchoneteCreateSandwichManager(
            mainDispatcher,
            FakeIngredientsGateway(),
            errorFactory
        )
    }

    private val publishScheduler: Scheduler by lazy {
        AndroidSchedulers.mainThread()
    }

    private val dispatcherFactory: DispatcherFactory by lazy {
        RxJavaDispatcherFactory(publishScheduler, Schedulers.computation())
    }

    private val errorFactory: ErrorFactory by lazy {
        FakeErrorFactory()
    }

    override fun onCreate() {
        super.onCreate()

        menuManager.setup()
        createSandwichManager.loadIngredients()
    }
}
