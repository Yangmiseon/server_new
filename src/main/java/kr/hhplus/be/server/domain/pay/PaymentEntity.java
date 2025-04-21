package kr.hhplus.be.server.domain.pay;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.base.ItemEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    String userCouponUseYN; //쿠폰사용여부

    String userCouponId; //사용한 쿠폰아이디

    @Column(nullable = false)
    BigDecimal discountTotal; //사용자가 할인받은 금액

    @Column(nullable = false)
    BigDecimal finalPrice; // 사용자가 결제한 최종금액

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PayStatusType type;

    LocalDateTime orderCurrentTime;//결제날짜및 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="itemId")
    ItemEntity itemId;
}
