package kr.hhplus.be.server.infrastructure.point;

import kr.hhplus.be.server.domain.point.PointHistoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PointHistoryRepositoryImpl implements PointHistoryRepository{
    private final JpaPointHistoryRepository jpaPointHistoryRepository;
    public PointHistoryRepositoryImpl(JpaPointHistoryRepository jpaPointHistoryRepository) {
        this.jpaPointHistoryRepository = jpaPointHistoryRepository;
    }

    @Override
    public List<PointHistoryEntity> findByUserId(String userId) {
        return jpaPointHistoryRepository.findByUserId(userId);
    }

    @Override
    public PointHistoryEntity save(PointHistoryEntity pointHistoryEntity) {
        return jpaPointHistoryRepository.save(pointHistoryEntity);
    }
}
