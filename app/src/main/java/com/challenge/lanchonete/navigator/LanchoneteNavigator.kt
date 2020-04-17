package com.challenge.lanchonete.navigator

import androidx.fragment.app.FragmentManager
import com.challenge.lanchonete.R
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
}
