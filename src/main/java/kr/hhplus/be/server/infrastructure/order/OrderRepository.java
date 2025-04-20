package kr.hhplus.be.server.infrastructure.order;

import kr.hhplus.be.server.domain.order.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository  {
    OrderEntity save(OrderEntity order);
    Optional<OrderEntity> findByIdAndUserId(String orderId, String userId);
    List<OrderEntity> findByUserIdOrderByOrderCurrentTimeDesc(String userId);
    Optional<OrderEntity> findByOrderId(String orderId);
    OrderEntity findByOrderIdOnly(String orderId);
}
