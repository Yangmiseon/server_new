package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.CouponEntity;
import kr.hhplus.be.server.domain.order.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCouponRepository extends JpaRepository<CouponEntity, String> {
    interface JpaOrderItemRepository extends JpaRepository<OrderItemEntity, String> {

    }
}
