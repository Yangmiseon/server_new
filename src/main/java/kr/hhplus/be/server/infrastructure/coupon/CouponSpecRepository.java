package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.application.coupon.CouponSpecRequestDto;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;

import java.util.Optional;
import java.util.UUID;


public interface CouponSpecRepository {

    Optional<CouponSpecEntity> findById(String couponId);
    CouponSpecEntity save(CouponSpecEntity couponSpecEntity);
    CouponSpecEntity create(CouponSpecRequestDto couponSpecRequestDto);
}