package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.ItemEntity;
import kr.hhplus.be.server.domain.OrderItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{

    private final JpaOrderItemRepository jpaOrderItemRepository;

    OrderItemRepositoryImpl(JpaOrderItemRepository jpaOrderItemRepository) {
        this.jpaOrderItemRepository = jpaOrderItemRepository;
    }

    @Override
    public List<OrderItemEntity> findByOrderOrderId(String orderId){
        return jpaOrderItemRepository.findByOrderOrderId(orderId);
    }

}
