package com.challenge.lanchonete.menu.list

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.lanchonete.R

class SandwichViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    private val sandwichName = itemView.findViewById<AppCompatTextView>(R.id.sandwichName)
    private val sandwichPrice = itemView.findViewById<AppCompatTextView>(R.id.sandwichPrice)
    private val sandwichIngredients = itemView.findViewById<AppCompatTextView>(R.id.sandwichIngredients)

    fun setSandwich(menuItemViewModel: MenuItemViewModel) {
        sandwichName.text = menuItemViewModel.name
        sandwichPrice.text = "${menuItemViewModel.price}$"
        sandwichIngredients.text = menuItemViewModel.ingredientsString
    }
}
