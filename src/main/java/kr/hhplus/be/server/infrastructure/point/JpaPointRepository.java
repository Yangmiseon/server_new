package kr.hhplus.be.server.infrastructure.point;

import kr.hhplus.be.server.domain.point.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  JpaPointRepository extends JpaRepository<PointEntity, String> {
    PointEntity findByUserId(String userId);
}
