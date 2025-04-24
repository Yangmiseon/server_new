package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCouponRepository extends JpaRepository<CouponEntity, String> {
    // 사용자로 쿠폰조회
    CouponEntity findByUserId(String Userid);

    // 쿠폰사용 후 업데이트
    CouponEntity update(CouponEntity coupon);

}
