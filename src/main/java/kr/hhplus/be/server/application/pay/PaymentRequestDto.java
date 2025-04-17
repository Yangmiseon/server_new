package kr.hhplus.be.server.application;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {
    private String userId;
    private List<OrderItemDto> items;
}
