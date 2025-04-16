package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JpaPointHistoryRepository extends JpaRepository<PointHistoryEntity, Long> {
    List<PointHistoryEntity> findByUserId(String userId);

    @Repository
    class OrderItemRepositoryImpl {
        private final JpaCouponRepository.JpaOrderItemRepository jpaOrderItemRepository;

        public OrderItemRepositoryImpl(JpaCouponRepository.JpaOrderItemRepository jpaOrderItemRepository) {
            this.jpaOrderItemRepository = jpaOrderItemRepository;
        }
    }

    interface OrderItemRepository {

    }
}
