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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    CouponType type;

    int couponTotalQuantity; //총수량

    int couponStockQuantity; //남은수량


}
