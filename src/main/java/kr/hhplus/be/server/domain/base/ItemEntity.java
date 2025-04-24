package kr.hhplus.be.server.domain.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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
    //ID생성
    public void generateId() {
        if (itemId == null) {
            String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM"));
            String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            this.itemId = "item" + yearMonth + "-" + uuidPart;
        }
    }

    @Column(nullable = false)
    String itemName;

    @Column(nullable = false)
    long itemPrice;

    @Column(nullable = false)
    int itemQuantity;
}
