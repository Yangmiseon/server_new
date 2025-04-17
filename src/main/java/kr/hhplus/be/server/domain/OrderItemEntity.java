package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="OrderItem")
public class OrderItemEntity {

    @Id
    String orderItemId; //주문아이템 아이디(pk)

    String itemId; //상품아이디(fk)

    int orderItemQuantity; //주문수량

    BigDecimal orderItemPrice; //상품가격

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orderId")
    OrderEntity order;


}
