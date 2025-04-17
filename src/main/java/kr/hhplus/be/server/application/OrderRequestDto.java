package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.CouponEntity;
import kr.hhplus.be.server.domain.OrderType;
import kr.hhplus.be.server.domain.UserEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private OrderType type;
    private String userId;
    private BigDecimal totalPrice;
    private BigDecimal pointUsed;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CouponRequestDto {
        private int id;
        private String couponId;
        private UserEntity userId;

        public CouponEntity toModel(){
            return CouponEntity.builder()
                    .id(id)
                    .couponId(couponId)
                    .userId(userId)
                    .build();
        }
    }
}
