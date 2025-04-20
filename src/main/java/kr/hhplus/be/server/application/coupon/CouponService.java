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

}
