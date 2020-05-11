package com.challenge.lanchonete.createsandwich.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.lanchonete.R
import com.challenge.lanchonete.models.Ingredient

class CreateSandwichViewHolder(
    itemView: View,
    private val clickListener: CreateSandwichAdapter.OnClickListener?
) : RecyclerView.ViewHolder(itemView) {
        private val ingredientName = itemView.findViewById<AppCompatTextView>(R.id.ingredientName)
        private val ingredientValue = itemView.findViewById<AppCompatTextView>(R.id.ingredientValue)
        private val ingredientQuantity = itemView.findViewById<AppCompatTextView>(R.id.ingredientQuantity)
        private val increaseIngredient = itemView.findViewById<AppCompatImageView>(R.id.increaseIngredient)

        fun setIngredient(ingredient: Ingredient) {
            ingredientName.text = ingredient.name
            ingredientValue.text = "${ingredient.value}$"
            ingredientQuantity.text = "${ingredient.quantity}"
            increaseIngredient.setOnClickListener {
                ingredient.quantity++
                ingredientQuantity.text = "${ingredient.quantity}"
                clickListener?.onClick(ingredient)
            }
        }
}
