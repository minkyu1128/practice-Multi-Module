package com.minkyu.order.repository

import jakarta.persistence.criteria.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>
