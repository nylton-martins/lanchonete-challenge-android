package com.challenge.lanchonete.navigator

import androidx.fragment.app.FragmentManager
import com.challenge.lanchonete.R
import com.challenge.lanchonete.createsandwich.CreateSandwichFragment
import com.challenge.lanchonete.menu.MenuFragment

open class LanchoneteNavigator(
    private val fragmentManager: FragmentManager
) : Navigator {
    override fun navigateToMenuView() {
        fragmentManager.beginTransaction()
            .replace(
                R.id.activity_container, MenuFragment())
            .commit()
    }

    override fun navigateToCreateSandwichView() {
        fragmentManager.beginTransaction()
            .replace(
                R.id.activity_container, CreateSandwichFragment())
            .addToBackStack("Menu->Create")
            .commit()
    }

    override fun navigateBack() {
        fragmentManager.popBackStack()
    }
}
