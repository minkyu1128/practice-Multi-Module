package com.minkyu.order.web

import com.minkyu.order.domain.Order
import com.minkyu.order.domain.OrderItem
import com.minkyu.order.domain.OrderLine
import com.minkyu.order.domain.Price
import com.minkyu.order.port.`in`.RegistOrderUserCase
import com.minkyu.order.port.`in`.RegisterOrderCommand
import jakarta.annotation.Nonnull
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/orders")
class RegisterOrderController(
    private val registOrderUserCase: RegistOrderUserCase
) {

    @PostMapping
    fun register(@Valid request: RegistOrderRequest): ResponseEntity<Void> {
        val order = request.requetOrderItem.map {
            it.toOrderItem()
        }.let {
            Order(
                orderLine = OrderLine(it)
            )
        }

        registOrderUserCase.regist(
            command = RegisterOrderCommand(order)
        )
        return ResponseEntity.ok().build()
    }
}

data class RegistOrderRequest(
    val requetOrderItem: List<RequetOrderItem>
)


data class RequetOrderItem(
    @Nonnull
    val name: String,
    @Nonnull
    val price: Long,
    @Nonnull
    val amount: Int
) {
    fun toOrderItem() = OrderItem(
        orderItemName = name,
        quantity = amount,
        price = Price.of(price)
    )
}
