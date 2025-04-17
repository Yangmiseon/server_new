package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.ItemEntity;
import kr.hhplus.be.server.domain.OrderItemEntity;


import java.util.List;

public interface OrderItemRepository {
    List<OrderItemEntity> findByOrderOrderId(String orderId);
}
