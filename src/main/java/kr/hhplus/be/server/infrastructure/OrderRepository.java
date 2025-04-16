package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.OrderEntity;

public interface OrderRepository  {
    OrderEntity save(OrderEntity order);

}
