package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.order.OrderType;
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

