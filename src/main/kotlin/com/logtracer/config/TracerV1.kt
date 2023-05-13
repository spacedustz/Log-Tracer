package com.logtracer.config

import com.logtracer.entity.TraceId
import com.logtracer.entity.TraceStatus
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Component

@Component
class TracerV1(
    val START_PREFIX: String = "-->",
    val COMPLETE_PREFIX: String = "<--",
    val EX_PREFIX: String = "<X-"
) {

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis()

        log.info(traceId.id, addSpace(START_PREFIX, traceId.level), message)

        return TraceStatus(traceId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status, null)
    }

    fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
    }

    fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId

        if (e == null) {
            log.info(traceId.id, addSpace(COMPLETE_PREFIX, traceId.level), status.message, resultTimeMs)
        } else {
            log.info(traceId.id, addSpace(EX_PREFIX, traceId.level), status.message, resultTimeMs)
        }

    }

    fun addSpace(prefix: String, level: Long): String {
        val sb: StringBuilder = StringBuilder()

        for (i in 0 .. level) {
            sb.append(if (i==level) "|$prefix" else "|   ")
        }
        return sb.toString()
    }

    companion object {
        private val log: Logger = LogManager.getLogger(this::class.java)
    }
}