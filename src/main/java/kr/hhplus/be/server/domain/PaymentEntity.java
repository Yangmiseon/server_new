package kr.hhplus.be.server.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="pay")
public class Payment {
    /*주문이 진행되면 결제로 온다.
    1. 쿠폰여부 확인한다.
    2. 결제한다.
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    int id;

    @Column(nullable = false)
    String payId;

    @Column(nullable = false)
    String orderId;

    @Column(nullable = false)
    String userCouponId;

    @Column(nullable = false)
    long amount;

    @Column(nullable = false)
    long finalPrice;

    @Column(nullable = false)
    long 

    @Column(nullable = false)
    String payStatus;
}
