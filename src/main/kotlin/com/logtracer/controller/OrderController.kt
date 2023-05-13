package com.logtracer.controller

import com.logtracer.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    @Autowired private val orderService: OrderService
) {

    @GetMapping("/request")
    fun request(itemId: String): String {
        orderService.orderItem(itemId)
        return "OK"
    }
}