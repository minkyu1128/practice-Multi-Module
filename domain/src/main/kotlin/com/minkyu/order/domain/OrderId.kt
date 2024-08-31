package com.minkyu.order.domain


data class OrderId(
    val orderId: Long
) : ValueObject {
    override fun getValue(): Long {
        return this.orderId
    }
}
