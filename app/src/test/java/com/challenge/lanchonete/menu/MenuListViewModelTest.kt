package com.challenge.lanchonete.menu

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.menu.list.MenuItemViewModel
import com.challenge.lanchonete.menu.list.MenuListViewModel
import junit.framework.Assert.assertEquals
import org.junit.Test

class MenuListViewModelTest {

    @Test
    fun `Given a menu list view model with a list of sandwiches When sandwiches are requested Then return menu item view model list`() {

        val sandwiches = TestData.LIST_OF_SANDWICHES

        val menuListViewModel = MenuListViewModel(
            sandwiches
        )

        val expectedResult: MutableList<MenuItemViewModel> =
            mutableListOf(
                MenuItemViewModel(
                    sandwiches[0]
                ),
                MenuItemViewModel(
                    sandwiches[1]

                ),
                MenuItemViewModel(
                    sandwiches[2]
                )
            )

        assertEquals(expectedResult, menuListViewModel.list)
    }
}
