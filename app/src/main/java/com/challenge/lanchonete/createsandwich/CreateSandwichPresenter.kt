package com.challenge.lanchonete.createsandwich

import com.challenge.lanchonete.createsandwich.list.IngredientListViewModel
import com.challenge.lanchonete.models.Ingredient
import com.challenge.lanchonete.state.Dispatcher
import com.challenge.lanchonete.state.State
import com.challenge.lanchonete.state.StateListener

class CreateSandwichPresenter(
    private val view: CreateSandwichView,
    private val mainDispatcher: Dispatcher
) : StateListener<List<Ingredient>> {
    override fun onStateUpdate(state: State<List<Ingredient>>) {
        mainDispatcher.dispatch {

            when (state.name) {
                State.Name.IDLE, State.Name.LOADING -> {
                    view.hideErrors()
                    view.hideIngredients()
                    view.showLoading()
                }
                State.Name.LOADED -> {
                    val ingredients = state.value!!
                    view.hideErrors()
                    view.hideLoading()
                    if (ingredients.isNotEmpty()) {
                        view.showIngredients(
                            IngredientListViewModel(
                                ingredients
                            )
                        )
                    } else {
                        view.hideIngredients()
                        view.showNoIngredientsError()
                    }
                }
                State.Name.ERROR -> {
                    view.hideIngredients()
                    view.hideLoading()
                    view.showUnknownError()
                }
            }
        }
    }
}
