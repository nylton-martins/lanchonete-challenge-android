package com.challenge.lanchonete.menu

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
import com.challenge.lanchonete.menu.list.MenuAdapter
import com.challenge.lanchonete.menu.list.MenuListViewModel
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment(), MenuView {

    private var container: MenuViewContainer? = null
    private var menuAdapter: MenuAdapter? = null
    private var menuLayoutManager: LinearLayoutManager? = null

    private val menuManager by lazy {
        container!!.menuManager
    }

    private val mainDispatcher by lazy {
        container!!.mainDispatcher
    }

    private val menuListener by lazy {
        MenuPresenter(this, mainDispatcher)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MenuViewContainer) {
            container = context
        } else {
            throw IllegalStateException("Context must implement ${MenuViewContainer::class.java.simpleName}")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuAdapter = MenuAdapter(
            LayoutInflater.from(context)
        )
        menuLayoutManager = LinearLayoutManager(context)
        sandwichList.layoutManager = menuLayoutManager
        sandwichList.adapter = menuAdapter
    }

    override fun onResume() {
        super.onResume()
        menuManager.registerListener(menuListener)
    }

    override fun onPause() {
        menuManager.unregisterListener(menuListener)
        super.onPause()
    }

    override fun onDestroyView() {
        menuAdapter = null
        menuLayoutManager = null
        super.onDestroyView()
    }

    override fun onDetach() {
        container = null
        super.onDetach()
    }

    override fun showSandwiches(menuListViewModel: MenuListViewModel) {
        sandwichList.visibility = VISIBLE
        menuAdapter!!.setSandwiches(menuListViewModel.list)
    }

    override fun hideSandwiches() {
        sandwichList.visibility = GONE
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

    override fun showNoSandwichesError() {
        errorView.text = getString(R.string.no_sandwiches_error)
        errorView.visibility = VISIBLE
    }

    override fun hideErrors() {
        errorView.visibility = GONE
    }
}
