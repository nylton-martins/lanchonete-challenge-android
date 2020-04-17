package com.challenge.lanchonete.menu

import com.challenge.lanchonete.menu.list.MenuListViewModel

interface MenuView {
    fun showSandwiches(menuListViewModel: MenuListViewModel)
    fun showLoading()
    fun hideLoading()
    fun showUnknownError()
    fun showNoSandwichesError()
    fun hideErrors()
    fun hideSandwiches()
}
