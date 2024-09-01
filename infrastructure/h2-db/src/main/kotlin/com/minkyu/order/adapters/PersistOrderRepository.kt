package com.minkyu.order.adapters

import com.minkyu.order.domain.Order
import com.minkyu.order.port.out.PersistOrderPort
import com.minkyu.order.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class PersistOrderRepository(
    private val orderRepository: OrderRepository
) : PersistOrderPort {
    override fun persist(order: Order): Order {
        TODO("Not yet implemented")
    }
}
