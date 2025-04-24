package kr.hhplus.be.server.domain.point;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="pointHistory")
public class PointHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransactionType type;

    BigDecimal amount;

    LocalDateTime currentTime;
}


