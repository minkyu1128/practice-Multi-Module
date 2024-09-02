package com.minkyu.order.domain

data class OrderItem(
    val orderItemId: Long? = null,
    val orderItemName: String,
    val quantity: Int,
    val price: Price
)
