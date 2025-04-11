package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String couponId;

    private String couponName;

    private String couponDesc;

    private CouponType type;

    private LocalDateTime issueDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userId;
}
