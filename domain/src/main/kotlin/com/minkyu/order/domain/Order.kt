package com.minkyu.order.domain

import java.math.BigDecimal

data class Order(
    val orderId: OrderId? = null,
    val orderLine: OrderLine,
    var totalPrice: BigDecimal? = null
) {
    init {
        this.totalPrice = orderLine.getTotalPrice()
    }
}
