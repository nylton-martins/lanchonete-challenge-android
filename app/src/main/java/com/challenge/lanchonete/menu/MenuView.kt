package com.challenge.lanchonete.menu

import com.challenge.lanchonete.menu.list.MenuListViewModel

interface MenuView {
    fun showSandwiches(menuListViewModel: MenuListViewModel)
    fun showLoading()
    fun hideLoading()
    fun hideError()
    fun showError()
    fun showNoSandwiches()
    fun hideSandwiches()
}
