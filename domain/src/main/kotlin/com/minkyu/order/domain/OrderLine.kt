package com.minkyu.order.domain

import java.math.BigDecimal

data class OrderLine(
    val orderItems: List<OrderItem>
) {
    fun getTotalPrice(): BigDecimal {
        return orderItems.sumOf { it.price.value }
    }
}
