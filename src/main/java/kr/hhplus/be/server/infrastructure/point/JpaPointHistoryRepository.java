package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JpaPointHistoryRepository extends JpaRepository<PointHistoryEntity, Long> {
    List<PointHistoryEntity> findByUserId(String userId);
}
