package com.challenge.lanchonete.menu

import com.challenge.lanchonete.menu.gateway.MenuGateway
import com.challenge.lanchonete.models.Sandwich

class TestMenuGateway(
    private val sandwiches: List<Sandwich> = emptyList()
) : MenuGateway {

    override fun getAllSandwiches(): List<Sandwich> {
        return sandwiches
    }
}
