package com.minkyu.order.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private val id: Long,

    @OneToMany(mappedBy = "order", fetch = LAZY)
    private val orderItems: Set<OrderItemEntity> = HashSet(),

    @Column(name = "total_price")
    private val totalPrice: Long
)
