package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.PointHistoryEntity;
import kr.hhplus.be.server.infrastructure.PointHistoryRepository;
import kr.hhplus.be.server.infrastructure.PointRepository;
import kr.hhplus.be.server.domain.TransactionType;
import org.springframework.stereotype.Service;
import kr.hhplus.be.server.domain.PointEntity;

import java.math.BigDecimal;
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
    public BigDecimal getUserPoint(String userId) {
        PointEntity point = pointRepository.findByUserId(userId);
        return point.getPointTotal();
    }

    //userId로 포인트 히스토리 조회
    public List<PointHistoryEntity> getUserPointHistory(String userId) {
        return pointHistoryRepository.findByUserId(userId);
    }

    //포인트 충전
    public PointEntity chargeUserPoint(String userId, BigDecimal amount) {
        final BigDecimal MAXPOINT = BigDecimal.valueOf(1_000_000);

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("충전 금액은 0보다 커야 합니다.");
        }

        if (amount.remainder(BigDecimal.TEN).signum() != 0) {
            throw new IllegalArgumentException("충전 금액은 10원 단위여야 합니다.");
        }

        if (amount.compareTo(MAXPOINT) > 0) {
            throw new IllegalArgumentException("충전 가능한 최대 포인트는 " + MAXPOINT + "입니다.");
        }

        // 현재 포인트 잔액 조회
        BigDecimal curPoint = pointRepository.findByUserId(userId).getPointTotal();
        amount = amount.add(curPoint);

        // 히스토리 기록 저장
        PointHistoryEntity historySave = new PointHistoryEntity();
        historySave.setUserId(userId);
        historySave.setAmount(amount);
        historySave.setType(TransactionType.CHARGE);
        historySave.setCurrentTime(LocalDateTime.now());
        pointHistoryRepository.save(historySave);

        // 포인트 업데이트
        PointEntity pointEntity = pointRepository.findByUserId(userId);
        pointEntity.setPointTotal(amount);
        return pointRepository.save(pointEntity);
    }


    // PointService
    public void validateEnough(BigDecimal point, BigDecimal total) {
        if (point.compareTo(total) < 0) {
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }
    }

}
