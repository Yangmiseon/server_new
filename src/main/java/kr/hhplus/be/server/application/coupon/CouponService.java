package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import kr.hhplus.be.server.domain.coupon.CouponType;
import kr.hhplus.be.server.infrastructure.coupon.CouponRepository;
import kr.hhplus.be.server.infrastructure.coupon.CouponSpecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;
    private final CouponSpecRepository couponSpecRepository;

    //유저로 쿠폰 조회
    public CouponEntity getCoupon(String userId) {
        return couponRepository.findByUserId(userId);
    }

    //쿠폰사용금액조회
    public BigDecimal calculateDiscountedPrice(
            CouponType couponType, // RATE or AMOUNT
            BigDecimal totalPrice,       // 원래 가격
            int discountValue      // 퍼센트 or 금액
    ) {
        return couponType.applyDiscount(totalPrice, discountValue);
    }

    //쿠폰 발급
    public synchronized CouponEntity IssuedCoupon(String userId, String couponSpecId ) {
        //쿠폰찾기
        CouponSpecEntity spec = couponSpecRepository.findById(couponSpecId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿠폰입니다."));

        if (spec.getCouponTotalQuantity() <= 0) {
            throw new IllegalStateException("쿠폰 수량이 모두 소진되었습니다.");
        }

        // 수량 감소
        spec.minusCouponCount();
        couponSpecRepository.save(spec);

        //유저한테 쿠폰생성
        CouponEntity issued = new CouponEntity();
        issued.setUserId(userId);
        issued.setCouponSpecEntity(spec);
        issued.setIssueDate(LocalDateTime.now());

        return couponRepository.save(issued);
    }
}
