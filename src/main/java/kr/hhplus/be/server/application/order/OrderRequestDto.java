package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.CouponEntity;
import kr.hhplus.be.server.domain.OrderType;
import kr.hhplus.be.server.domain.UserEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

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

    private List<OrderItemRequestDto> items;


}

