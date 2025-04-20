package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;


public interface CouponRepository {
    // 어떤 종류의 쿠폰을 발급할건지 관리자가 등록
    CouponEntity save(CouponEntity couponIssued);

    // 사용자로 쿠폰조회
    CouponEntity findByUserId(String Userid);

    // 쿠폰사용 후 업데이트
    CouponEntity update(CouponEntity coupon);

}