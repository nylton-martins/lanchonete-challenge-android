package com.challenge.lanchonete.createsandwich.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.challenge.lanchonete.R

class CreateSandwichViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
        private val ingredientName = itemView.findViewById<AppCompatTextView>(R.id.ingredientName)
        private val ingredientValue = itemView.findViewById<AppCompatTextView>(R.id.ingredientValue)
        private val ingredientQuantity = itemView.findViewById<AppCompatTextView>(R.id.ingredientQuantity)
        private val increaseIngredient = itemView.findViewById<AppCompatImageView>(R.id.increaseIngredient)

        fun setIngredient(ingredientItemViewModel: IngredientItemViewModel) {
            ingredientName.text = ingredientItemViewModel.name
            ingredientValue.text = "${ingredientItemViewModel.value}$"
            increaseIngredient.setOnClickListener {
            }
        }
}
