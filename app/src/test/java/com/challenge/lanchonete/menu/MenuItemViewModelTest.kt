package com.challenge.lanchonete.menu

import com.challenge.lanchonete.TestData
import com.challenge.lanchonete.menu.list.MenuItemViewModel
import junit.framework.Assert.assertEquals
import org.junit.Test

class MenuItemViewModelTest {

    @Test
    fun `Given a sandwich with a list of ingredients When ingredients are requested Then return a string with all the ingredients`() {
        val viewModel = MenuItemViewModel(
            TestData.LIST_OF_SANDWICHES[0]
        )

        assertEquals("Cheese, Egg, Bacon", viewModel.ingredientsString)
    }
}
