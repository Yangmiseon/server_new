package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="Order")
public class OrderEntity {

    @Id
    @Column(nullable = false)
    String orderId; // 주문아이디

    String orderItemId; //주문목록아이디

    String userId; //주문자

    long pointUsed; //사용가능포인트

    long totalPrice; //전체가격

    LocalDateTime orderCurrentTime;//주문날짜및 시간

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItems = new ArrayList<>();


}
