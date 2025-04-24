package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CouponSpecRequestDto {

    private String couponId;
    //쿠폰 종류 (할인률/정액)
    private CouponType type;

    //할인일경우 몇퍼센트인지, 정액일경우 얼마인지 등록
    private int couponDiscount;

    //몇장발급할건지설정
    private int couponTotalQuantity; //총수량
}
