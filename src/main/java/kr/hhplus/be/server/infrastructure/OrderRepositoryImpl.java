package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.OrderEntity;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository=jpaOrderRepository;
    }

    @Override
    public OrderEntity save(OrderEntity order){
        return jpaOrderRepository.save(order);
    }
}
