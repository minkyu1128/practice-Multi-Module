package com.minkyu.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne


@Entity(name = "order_item")
data class OrderItemEntity(
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    val id: Long,

    @Column(name = "name")
    val name: String,

    @Column(name = "amount")
    val amount: Long,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    val order: OrderEntity
)
