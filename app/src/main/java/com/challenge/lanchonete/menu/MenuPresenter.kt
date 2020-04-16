package com.challenge.lanchonete.menu

import com.challenge.lanchonete.menu.list.MenuListViewModel
import com.challenge.lanchonete.models.Sandwich
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateListener

class MenuPresenter(
    private val view: MenuView,
    private val mainDispatcher: Dispatcher
) : StateListener<List<Sandwich>> {
    override fun onStateUpdate(state: State<List<Sandwich>>) {
        mainDispatcher.dispatch {

            when (state.name) {
                State.Name.IDLE, State.Name.LOADING -> {
                    view.hideError()
                    view.hideSandwiches()
                    view.showLoading()
                }
                State.Name.LOADED -> {
                    val sandwiches = state.value!!
                    view.hideError()
                    view.hideLoading()
                    if (sandwiches.isNotEmpty()) {
                        view.showSandwiches(
                            MenuListViewModel(
                                sandwiches
                            )
                        )
                    } else {
                        view.hideSandwiches()
                        view.showNoSandwiches()
                    }
                }
                State.Name.ERROR -> {
                    view.hideSandwiches()
                    view.hideLoading()
                    view.showError()
                }
            }
        }
    }
}
