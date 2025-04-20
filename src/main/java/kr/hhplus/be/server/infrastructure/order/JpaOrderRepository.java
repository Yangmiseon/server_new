package kr.hhplus.be.server.infrastructure.order;

import kr.hhplus.be.server.domain.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, String> {
    Optional<OrderEntity> findByIdAndUserId(String orderId, String userId);
    List<OrderEntity> findByUserIdOrderByOrderCurrentTimeDesc(String userId);
    OrderEntity findByOrderIdOnly(String orderId);
}

