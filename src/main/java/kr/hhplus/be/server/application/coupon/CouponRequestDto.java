package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.CouponEntity;
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

    public CouponEntity toModel(){
        return CouponEntity.builder()

                .couponId(couponId)
                .userId(userId)
                .build();
    }
}