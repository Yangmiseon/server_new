package kr.hhplus.be.server.infrastructure.point;

import kr.hhplus.be.server.domain.point.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPointHistoryRepository extends JpaRepository<PointHistoryEntity, Long> {
    List<PointHistoryEntity> findByUserId(String userId);
}
