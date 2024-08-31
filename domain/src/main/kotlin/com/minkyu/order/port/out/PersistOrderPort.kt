package com.minkyu.order.port.out

import com.minkyu.order.domain.Order


interface PersistOrderPort {
    fun persist(order: Order): Order
}

data class PersistOrderCommand(
    val order: Order
)
