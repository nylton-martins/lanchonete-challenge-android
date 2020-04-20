package com.challenge.lanchonete.createsandwich.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.lanchonete.R

class CreateSandwichAdapter(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<CreateSandwichViewHolder>() {
    private val items: MutableList<IngredientItemViewModel> = mutableListOf()

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.ingredient_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateSandwichViewHolder {
        return CreateSandwichViewHolder(
            inflater.inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CreateSandwichViewHolder, position: Int) {
        holder.setIngredient(items[position])
    }

    fun setIngredients(ingredientItems: List<IngredientItemViewModel>) {
        items.clear()
        items.addAll(ingredientItems)
        notifyDataSetChanged()
    }
}
