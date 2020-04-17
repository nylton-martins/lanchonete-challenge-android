package com.challenge.lanchonete.menu.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.lanchonete.R

class MenuAdapter(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<SandwichViewHolder>() {
    private val items: MutableList<MenuItemViewModel> = mutableListOf()

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.sandwich_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SandwichViewHolder {
        return SandwichViewHolder(
            inflater.inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SandwichViewHolder, position: Int) {
        holder.setSandwich(items[position])
    }

    fun setSandwiches(sandwichItems: List<MenuItemViewModel>) {
        items.clear()
        items.addAll(sandwichItems)
        notifyDataSetChanged()
    }
}
