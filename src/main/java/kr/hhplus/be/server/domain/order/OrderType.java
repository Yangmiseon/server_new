package kr.hhplus.be.server.domain;
/*
    REQUESTED     주문요청
    PROCESSING    주문처리중
    COMPLETED     주문완료
    CANCELED      주문취소
    FAILED        주문실패
* */
public enum OrderType {
    REQUESTED, PROCESSING, COMPLETED, CANCELED,FAILED
}
