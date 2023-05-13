package com.logtracer.entity

import java.util.UUID

/**
 * @author 신건우
 * @param id : 트랜잭션 ID
 * @param level : 트랜잭션 깊이
 * @desc 단순히 트랜잭션의 id, level을 표현하는 클래스
 */
data class TraceId(
    var id: String,
    var level: Long
) {

    constructor() : this(UUID.randomUUID().toString().substring(0, 8), 0)

    fun createId(): String {
        return UUID.randomUUID().toString().substring(0, 8)
    }

    fun createNextId(): TraceId {
        return TraceId(id, level.plus(1))
    }

    fun createPrevId(): TraceId {
        return TraceId(id, level.minus(1))
    }

    fun isFirstLevel(): Boolean {
        return level == 0L
    }
}