package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.PointHistoryEntity;
import kr.hhplus.be.server.infrastructure.PointHistoryRepository;
import kr.hhplus.be.server.infrastructure.PointRepository;
import kr.hhplus.be.server.domain.TransactionType;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.domain.PointEntity;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PointService {
    private final PointRepository pointRepository;
    private final PointHistoryRepository pointHistoryRepository;

    public PointService(
            PointRepository pointRepository,
            PointHistoryRepository pointHistoryRepository
    ) {
        this.pointRepository = pointRepository;
        this.pointHistoryRepository = pointHistoryRepository;
    }

    //userId로 현재 포인트 조회
    public long getUserPoint(String userId) {
        PointEntity point = pointRepository.findByUserId(userId);
        return point.getPointTotal();
    }

    //userId로 포인트 히스토리 조회
    public List<PointHistoryEntity> getUserPointHistory(String userId) {
        return pointHistoryRepository.findByUserId(userId);
    }

    //포인트 충전
    public PointEntity chargeUserPoint(String userId, long amount){
        //현재 포인트 잔액조회
        long curPoint = pointRepository.findByUserId(userId).getPointTotal();
        //현재 포인트에 충전포인트 담기(최대값 확인하기)
        final long MAXPOINT = 1_000_000L;
        if(amount > MAXPOINT){
            throw new IllegalArgumentException("충전 가능한 최대 포인트는 " + MAXPOINT + "입니다.");
        }else{
            amount += curPoint;
            //히스토리 넣어주기
            pointHistoryRepository.insert(userId, amount, TransactionType.CHARGE, LocalDateTime.now());
            //포인트 업데이트하기
            return pointRepository.insertAndUpdate(userId, amount);
        }

    }
}
