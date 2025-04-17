package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PointEntity;
import org.springframework.stereotype.Repository;


public interface  PointRepository {
    //사용자 아이디로 사용자의 포인트 리스트 조회
    PointEntity findByUserId(String userId);
    PointEntity save(PointEntity point);
}
