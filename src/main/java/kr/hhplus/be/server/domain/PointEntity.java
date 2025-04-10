package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="point")
public class PointEntity {
    @Id
    @Column(unique = true, nullable = false)
    String userId;

    @Column(nullable = false)
    long amount;

    @Column(nullable = false)
    long pointTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransactionType type;

    @Column
    LocalDateTime pointChargeTime;

    @Column
    LocalDateTime pointUseTime;

}