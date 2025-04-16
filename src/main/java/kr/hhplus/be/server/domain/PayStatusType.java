package kr.hhplus.be.server.domain;
/*
IN_PROGRESS   결제중
PENDING       결제대기
COMPLETED     결제완료
CANELLED      결제취소
*/
public enum PayStatusType {
    IN_PROGRESS,PENDING,COMPLETED,CANCELLED
}
