package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.application.PointService;
import kr.hhplus.be.server.domain.PointEntity;
import kr.hhplus.be.server.domain.PointHistoryEntity;
import kr.hhplus.be.server.domain.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PointHistoryRepository extends JpaRepository<PointHistoryEntity, Integer> {
    List<PointHistoryEntity> findByUserId(String userId);
    PointHistoryEntity insert(String userId, long amount, TransactionType type, LocalDateTime pointChargeTime );
}
