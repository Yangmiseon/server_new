package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.base.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequestDto {
    private int id;
    private String couponId;
    private UserEntity userId;
    //선착순 쿠폰발행
    public CouponEntity toModel(){
        return CouponEntity.builder()

                .couponId(couponId)
                .userId(userId)
                .build();
    }
}