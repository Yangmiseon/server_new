package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


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

    @Override
    public Optional<OrderEntity> findByIdAndUserId(String orderId, String userId) {
        return jpaOrderRepository.findByIdAndUserId(orderId,userId);
    }

    //사용자의 주문목록조회
    @Override
    public List<OrderEntity> findByUserIdOrderByOrderCurrentTimeDesc(String userId){
        return jpaOrderRepository.findByUserIdOrderByOrderCurrentTimeDesc(userId);
    }

    @Override
     public Optional<OrderEntity> findByOrderId(String orderId) {
        return jpaOrderRepository.findById(orderId);
    }
}
