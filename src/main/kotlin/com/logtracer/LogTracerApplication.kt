package com.logtracer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogTracerApplication

fun main(args: Array<String>) {
    runApplication<LogTracerApplication>(*args)
}