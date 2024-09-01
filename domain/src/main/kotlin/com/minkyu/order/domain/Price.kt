package com.minkyu.order.domain

import java.math.BigDecimal

data class Price(
    val value: BigDecimal
) : ValueObject {
    override fun getValue(): Any {
        return this.value
    }

    companion object {
        fun of(value: Long) = Price(BigDecimal.valueOf(value))
    }
}
