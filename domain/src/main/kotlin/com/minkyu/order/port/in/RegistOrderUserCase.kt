package com.minkyu.order.port.`in`

import com.minkyu.order.domain.Order
import com.minkyu.order.domain.Price


interface RegistOrderUserCase {
    fun regist(command: RegisterOrderCommand): Order
}

data class RegisterOrderCommand(
    val order: Order
)

data class RegisterOrderItem(
    val name: String,
    val price: Price
)
