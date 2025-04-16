package kr.hhplus.be.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="item")
public class ItemEntity {

    @Id
    @Column(nullable = false)
    String itemId;

    @Column(nullable = false)
    String itemName;

    @Column(nullable = false)
    long itemPrice;

    @Column(nullable = false)
    int itemQuantity;
}
