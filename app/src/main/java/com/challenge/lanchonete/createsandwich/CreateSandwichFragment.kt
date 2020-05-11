package com.challenge.lanchonete.createsandwich

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.lanchonete.R
import com.challenge.lanchonete.createsandwich.list.CreateSandwichAdapter
import com.challenge.lanchonete.models.Ingredient
import kotlinx.android.synthetic.main.fragment_create_sandwich.*

class CreateSandwichFragment : Fragment(), CreateSandwichView {

    private var container: CreateSandwichViewContainer? = null
    private var createSandwichAdapter: CreateSandwichAdapter? = null
    private var createSandwichLayoutManager: LinearLayoutManager? = null

    private val createSandwichManager by lazy {
        container!!.createSandwichManager
    }

    private val mainDispatcher by lazy {
        container!!.mainDispatcher
    }

    private val navigator by lazy {
        container!!.navigator
    }

    private val promotionManager by lazy {
        container!!.promotionManager
    }

    private val createSandwichListener by lazy {
        CreateSandwichPresenter(this, mainDispatcher)
    }

    private val calculatePromotionListener by lazy {
        CalculatePromotionPresenter(this, mainDispatcher)
    }

    private val onIngredientClickListener by lazy {
        object : CreateSandwichAdapter.OnClickListener {
            override fun onClick(ingredient: Ingredient) {
                promotionManager.calculateSandwichPrice(ingredient)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CreateSandwichViewContainer) {
            container = context
        } else {
            throw IllegalStateException("Context must implement ${CreateSandwichViewContainer::class.java.simpleName}")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_sandwich, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createSandwichAdapter = CreateSandwichAdapter(
            LayoutInflater.from(context)
        )
        createSandwichLayoutManager = LinearLayoutManager(context)
        ingredientsList.layoutManager = createSandwichLayoutManager
        ingredientsList.adapter = createSandwichAdapter
    }

    override fun onResume() {
        super.onResume()
        createSandwichManager.registerListener(createSandwichListener)
        promotionManager.registerListener(calculatePromotionListener)
        createSandwichAdapter!!.clickListener = onIngredientClickListener
    }

    override fun onPause() {
        createSandwichManager.unregisterListener(createSandwichListener)
        promotionManager.unregisterListener(calculatePromotionListener)
        super.onPause()
    }

    override fun onDestroyView() {
        createSandwichAdapter = null
        createSandwichLayoutManager = null
        super.onDestroyView()
    }

    override fun onDetach() {
        container = null
        super.onDetach()
    }

    override fun showIngredients(ingredients: List<Ingredient>) {
        ingredientsList.visibility = VISIBLE
        createSandwichAdapter!!.setIngredients(ingredients)
    }

    override fun hideIngredients() {
        ingredientsList.visibility = GONE
    }

    override fun showLoading() {
        loading.visibility = VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = GONE
    }

    override fun showUnknownError() {
        errorView.text = getString(R.string.unknown_error)
        errorView.visibility = VISIBLE
    }

    override fun showNoIngredientsError() {
        errorView.text = getString(R.string.no_sandwiches_error)
        errorView.visibility = VISIBLE
    }

    override fun hideErrors() {
        errorView.visibility = GONE
    }

    override fun hidePrice() {
        priceViews.visibility = GONE
    }

    override fun showPrice(price: Double) {
        priceViews.visibility = VISIBLE
        priceValue.text = "$price$"
    }
}
