package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponIssuedRepository extends JpaRepository<CouponEntity, Integer> {
    CouponEntity findByCouponId(String couponId);
}
