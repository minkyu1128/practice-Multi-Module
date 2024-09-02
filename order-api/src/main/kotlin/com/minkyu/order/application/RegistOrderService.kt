package com.minkyu.order.application

import com.minkyu.order.domain.Order
import com.minkyu.order.port.`in`.RegistOrderUserCase
import com.minkyu.order.port.`in`.RegisterOrderCommand
import com.minkyu.order.port.out.PersistOrderPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegistOrderService(
    private val persistOrderPort: PersistOrderPort
) : RegistOrderUserCase {
    @Transactional
    override fun regist(command: RegisterOrderCommand): Order {
        val order = command.order
        // todo something
        val newOrder = persistOrderPort.persist(order)
        return newOrder
    }
}
