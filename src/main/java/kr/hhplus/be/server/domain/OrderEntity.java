package kr.hhplus.be.server.domain;

import java.util.Date;

public class OrderEntity {

    String orderId;
    Date orderDate;
    String user_coupon;
    long itemDiscount;
    long pointUsed;
    long totalPrice;
}
