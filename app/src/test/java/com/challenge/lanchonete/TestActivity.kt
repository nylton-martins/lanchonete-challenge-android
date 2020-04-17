package com.challenge.lanchonete

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.challenge.lanchonete.menu.MenuManager
import com.challenge.lanchonete.menu.MenuViewContainer
import com.challenge.lanchonete.menu.fakes.FakeMenuManager
import com.challenge.lanchonete.navigator.Navigator
import com.challenge.lanchonete.rxjava.RxJavaDispatcher
import com.challenge.lanchonete.state.Dispatcher
import io.mockk.mockk
import io.reactivex.schedulers.Schedulers

class TestActivity : AppCompatActivity(), MenuViewContainer {

    var testNavigator: Navigator = mockk(relaxed = true)
    var testMenuManager: MenuManager =
        FakeMenuManager()
    var testPublishDispatcher: Dispatcher = RxJavaDispatcher(
        Schedulers.trampoline(),
        Schedulers.trampoline()
    )

    override val navigator: Navigator by lazy {
        testNavigator
    }

    override val menuManager: MenuManager by lazy {
        testMenuManager
    }

    override val mainDispatcher: Dispatcher by lazy {
        testPublishDispatcher
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        val view = LinearLayout(this)
        view.id = 1
        setContentView(view)
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(1, fragment)
            .commit()
    }
}
