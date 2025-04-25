package kr.hhplus.be.server.domain.coupon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="CouponSpec")
public class CouponSpecEntity {//쿠폰의 종류 및 수량설정

    @Id
    @Column(nullable = false)
    private String couponSpecId;

    //ID생성
    @PrePersist
    public void generateId() {
        if (couponSpecId == null) {
            String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM"));
            String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
            this.couponSpecId = "COUPON" + yearMonth + "-" + uuidPart;
        }
    }

    private String couponSpecName; //쿠폰이름

    //쿠폰 종류 (할인률/정액)
    private CouponType type;

    //할인일경우 몇퍼센트인지, 정액일경우 얼마인지 등록
    private int couponDiscount;

    //몇장발급할건지설정
    private int couponTotalQuantity; //총수량

    //쿠폰 수량줄이기
    public void minusCouponCount() {
        if (this.couponTotalQuantity < 0) {
            throw new IllegalArgumentException("쿠폰 발급이 종료되었습니다.");
        }
        this.couponTotalQuantity--;
    }

}
