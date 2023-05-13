package com.logtracer.repository

import org.springframework.stereotype.Repository

@Repository
class OrderRepository {

    fun sava(itemId: String) {
        if (itemId == "ex") throw IllegalStateException("예외 발생")
        sleep(1000)
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}