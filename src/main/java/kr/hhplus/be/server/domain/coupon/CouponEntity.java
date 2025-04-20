package kr.hhplus.be.server.domain.coupon;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.base.UserEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="coupon")
public class CouponEntity {

    @Id
    @Column(nullable = false)
    private String couponId; //쿠폰아이디

    private String couponName; //쿠폰이름

    private CouponType type; // 쿠폰타입(정률/할인)

    private BigDecimal couponDiscount;

    private LocalDateTime issueDate; // 쿠폰발급일

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userId; //쿠폰발급대상
}
