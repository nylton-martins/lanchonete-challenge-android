package com.challenge.lanchonete.menu.list

import com.challenge.lanchonete.models.Sandwich

data class MenuListViewModel(
    val sandwiches: List<Sandwich>
) {
    val list: List<MenuItemViewModel> = sandwiches.map { sandwich ->
        MenuItemViewModel(
            sandwich
        )
    }
}
