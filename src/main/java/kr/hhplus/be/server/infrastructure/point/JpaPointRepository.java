package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  JpaPointRepository extends JpaRepository<PointEntity, String> {
    PointEntity findByUserId(String userId);
}
