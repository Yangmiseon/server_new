package kr.hhplus.be.server.domain;

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
@Table(name ="couponQuantity")
public class CouponQuantityEntity {

    @Id
    @Column(nullable = false)
    private String couponId;

    private CouponType type;

    private int couponTotalQuantity; //총수량

    private int couponStockQuantity; //남은수량


}
