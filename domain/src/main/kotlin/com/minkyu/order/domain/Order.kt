package com.minkyu.order.domain

data class Order(
    val orderId: OrderId? = null,
    val orderLine: OrderLine
)
