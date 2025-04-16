package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findByUserId(String userId);
    List<OrderEntity> findByOrderId(String orderId);

}

