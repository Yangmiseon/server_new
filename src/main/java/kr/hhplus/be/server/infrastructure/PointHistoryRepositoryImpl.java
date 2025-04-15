package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointHistoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PointHistoryRepositoryImpl implements PointHistoryRepository{
    private final JpaPointHistoryRepository jpaPointHistoryRepository;
    public PointHistoryRepositoryImpl(JpaPointHistoryRepository jpaPointHistoryRepository) {
        this.jpaPointHistoryRepository = jpaPointHistoryRepository;
    }

    @Override
    public PointHistoryEntity save(PointHistoryEntity pointHistoryEntity) {
        return jpaPointHistoryRepository.save(pointHistoryEntity);
    }
}
