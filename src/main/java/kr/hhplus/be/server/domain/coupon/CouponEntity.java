package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.base.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name ="coupon")
public class CouponEntity {

    @Id
    @Column(nullable = false)
    private String couponId; //쿠폰아이디

    private String couponName; //쿠폰이름

    private CouponType type; // 쿠폰타입(정률/할인)

    private LocalDateTime issueDate; // 쿠폰발급일

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userId; //쿠폰발급대상
}
