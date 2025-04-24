package kr.hhplus.be.server.application.pay;

import kr.hhplus.be.server.domain.order.OrderItemEntity;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {
    private String userId;
    private List<OrderItemEntity> items;
}
