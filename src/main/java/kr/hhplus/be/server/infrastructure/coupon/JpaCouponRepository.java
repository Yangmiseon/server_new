package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.order.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCouponRepository extends JpaRepository<CouponEntity, String> {
    CouponEntity findByUserId(String Userid);
}
