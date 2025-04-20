package kr.hhplus.be.server.infrastructure.point;


import kr.hhplus.be.server.domain.point.PointHistoryEntity;

import java.util.List;


public interface PointHistoryRepository{
    List<PointHistoryEntity> findByUserId(String userId);
    PointHistoryEntity save(PointHistoryEntity point);
}
