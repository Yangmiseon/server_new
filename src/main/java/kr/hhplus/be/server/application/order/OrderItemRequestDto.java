package kr.hhplus.be.server.application;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequestDto {
    private String itemId;
    private int quantity;
    private BigDecimal price;
}
