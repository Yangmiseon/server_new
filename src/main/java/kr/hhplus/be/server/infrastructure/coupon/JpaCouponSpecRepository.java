package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.application.coupon.CouponSpecRequestDto;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCouponSpecRepository extends JpaRepository<CouponSpecEntity, String> {
    CouponSpecEntity create(CouponSpecRequestDto couponSpecRequestDto);

}
