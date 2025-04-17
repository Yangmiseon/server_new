package kr.hhplus.be.server.infrastructure;


import kr.hhplus.be.server.domain.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface JpaOrderItemRepository extends JpaRepository<OrderItemEntity, String> {
    List<OrderItemEntity> findByOrderOrderId(String orderId);

}
