package kr.hhplus.be.server.infrastructure.order;

import kr.hhplus.be.server.domain.order.OrderItemEntity;


import java.util.List;

public interface OrderItemRepository {
    List<OrderItemEntity> findByOrderOrderId(String orderId);
}
