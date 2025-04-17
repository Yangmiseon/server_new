package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @PrePersist
    //ID생성
    public void generateId() {
        if (orderId == null) {
            String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM"));
            String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            this.orderId = "ORDER" + yearMonth + "-" + uuidPart;
        }
    }

    String orderItemId; //주문목록아이디

    String userId; //주문자

    BigDecimal pointUsed; //사용가능포인트

    BigDecimal totalPrice; //전체가격

    OrderType type;

    LocalDateTime orderCurrentTime;//주문날짜및 시간

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItems = new ArrayList<>();

}
