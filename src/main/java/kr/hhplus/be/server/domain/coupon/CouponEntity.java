package kr.hhplus.be.server.domain.coupon;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.base.UserEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="coupon")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID couponId; // 발급 시 UUID 생성

    @ManyToOne(fetch = FetchType.LAZY)
    private CouponSpecEntity couponSpecEntity;

    private LocalDateTime issueDate; // 쿠폰발급일

    private String userId; //쿠폰발급대상
}
