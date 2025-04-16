package kr.hhplus.be.server.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="payment")
public class PaymentEntity {
    /*주문이 진행되면 결제로 온다.
    1. 쿠폰여부 확인한다.
    2. 결제한다.
    * */

    @Id
    @Column(nullable = false)
    String payId;

    @PrePersist
    //ID생성
    public void generateId() {
        if (payId == null) {
            String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM"));
            String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            this.payId = "PAY" + yearMonth + "-" + uuidPart;
        }
    }

    @Column(nullable = false)
    String orderId;

    @Column(nullable = false)
    String userCouponYN;

    String userCouponId;

    @Column(nullable = false)
    BigDecimal pointTotal; //사용자가 사용할 포인트

    @Column(nullable = false)
    BigDecimal finalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PayStatusType type;
}
