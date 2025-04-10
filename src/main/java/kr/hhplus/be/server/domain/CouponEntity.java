package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="coupon")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    int id;

    String couponId;

    String couponName;

    String couponDesc;

    CouponType type;

    LocalDateTime issueDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    UserEntity userId;
}
