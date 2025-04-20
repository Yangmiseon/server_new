package kr.hhplus.be.server.infrastructure.point;

import kr.hhplus.be.server.domain.point.PointEntity;


public interface  PointRepository {
    //사용자 아이디로 사용자의 포인트 리스트 조회
    PointEntity findByUserId(String userId);
    PointEntity save(PointEntity point);
}
