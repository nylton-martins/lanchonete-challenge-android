package com.challenge.lanchonete.menu.gateway

import com.challenge.lanchonete.models.Sandwich

interface MenuGateway {

    fun getAllSandwiches(): List<Sandwich>
}
