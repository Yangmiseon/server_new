package kr.hhplus.be.server.domain;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequestDto {
    private int id;
    private String couponId;
    private UserEntity userId;

    public  CouponEntity toModel(){
        return CouponEntity.builder()
                .id(id)
                .couponId(couponId)
                .userId(userId)
                .build();
    }
}

