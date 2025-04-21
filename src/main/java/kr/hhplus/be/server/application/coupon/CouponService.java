package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.coupon.CouponType;
import kr.hhplus.be.server.infrastructure.coupon.CouponRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CouponService {

    private CouponRepository couponRepository;
    private CouponEntity couponEntity;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

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
}
