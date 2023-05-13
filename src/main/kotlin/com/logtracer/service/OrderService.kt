package com.logtracer.service

import com.logtracer.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService(
    @Autowired private val orderRepository: OrderRepository
) {

    fun orderItem(itemId: String) {
        orderRepository.sava(itemId)
    }
}