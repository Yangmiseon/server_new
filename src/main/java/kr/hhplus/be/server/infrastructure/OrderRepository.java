package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  {
    OrderEntity save(OrderEntity order);
    Optional<OrderEntity> findByIdAndUserId(String orderId, String userId);
    List<OrderEntity> findByUserIdOrderByOrderCurrentTimeDesc(String userId);
}
