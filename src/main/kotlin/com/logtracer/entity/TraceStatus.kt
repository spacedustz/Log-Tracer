package com.logtracer.entity

/**
 * @author 신건우
 * @param traceId : 트랜잭션의 ID와 Level 보유
 * @param startTimeMs : 로그의 시작시간, 로그 종료 시 이걸 기준으로 시작~종료 전체 수행 시간을 구한다
 * @param message : 시작 시 사용한 메시지, 이후 로그 종료시에도 이 메시지를 사용해서 출력한다
 * @desc 로그의 상태 정보 클래스
 */
data class TraceStatus (
    val traceId: TraceId,
    val startTimeMs: Long,
    val message: String
)