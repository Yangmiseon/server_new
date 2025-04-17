package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PointRepositoryImpl implements PointRepository{
    private final JpaPointRepository jpaPointRepository;

    public PointRepositoryImpl(JpaPointRepository jpaPointRepository) {
        this.jpaPointRepository = jpaPointRepository;
    }

    @Override
    public PointEntity findByUserId(String userId) {

        return jpaPointRepository.findByUserId(userId);
    }

    @Override
    public PointEntity save(PointEntity point) {
        return jpaPointRepository.save(point);
    }
}
