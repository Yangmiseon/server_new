package kr.hhplus.be.server.domain;

import kr.hhplus.be.server.application.point.PointService;
import kr.hhplus.be.server.domain.point.PointEntity;
import kr.hhplus.be.server.domain.point.PointHistoryEntity;
import kr.hhplus.be.server.domain.point.TransactionType;
import kr.hhplus.be.server.infrastructure.point.PointHistoryRepository;
import kr.hhplus.be.server.infrastructure.point.PointRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PointTest {

    @InjectMocks
    private PointService pointService;  // 진짜 대상

    @Mock
    private PointRepository pointRepository;  // 의존성은 Mock

    @Mock
    private PointHistoryRepository pointHistoryRepository;


    @Test
    @DisplayName("포인트 조회")
    void testPointTotal() {
        //포인트 조회
        String userId = "abc";
        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId(userId);
        fakePoint.setPointTotal(BigDecimal.valueOf(1000));

        // 유저아이디로 포인트를 조회할때
        when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);

        // 결과는 1000이 조회돼야 한다.
        BigDecimal result = pointService.getUserPoint(userId);

        // 조회되는값이 1000과 같은가?
        assertEquals(1000L, result);
    }

    @Test
    @DisplayName("포인트 히스토리조회")
    void testPointHistory() {
        //포인트내역조회
        String userId = "abc";

        PointHistoryEntity history1 = new PointHistoryEntity();
        history1.setUserId(userId);
        history1.setType(TransactionType.CHARGE);
        history1.setAmount(BigDecimal.valueOf(1000));
        history1.setCurrentTime(LocalDateTime.now());

        PointHistoryEntity history2 = new PointHistoryEntity();
        history2.setUserId(userId);
        history2.setType(TransactionType.USE);
        history2.setAmount(BigDecimal.valueOf(500));
        history2.setCurrentTime(LocalDateTime.now());

        List<PointHistoryEntity> fakeHistoryList = List.of(history1, history2);

        when(pointHistoryRepository.findByUserId(userId)).thenReturn(fakeHistoryList);

        // when
        List<PointHistoryEntity> result = pointService.getUserPointHistory(userId);

        // then
        assertEquals(2, result.size());
        assertEquals(1000, result.get(0).getAmount());
        assertEquals(TransactionType.CHARGE, result.get(0).getType());
    }



    @Test
    @DisplayName("포인트 마이너스로 충전")
    void exceptionAmount() {
        // 마이너스값
        String userId = "abc";
        long amount = -100L;

        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId(userId);
        fakePoint.setPointTotal(BigDecimal.valueOf(1000));

        // when & then: 예외가 발생하는지 확인
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pointService.chargeUserPoint(userId, BigDecimal.valueOf(amount))
        );

        // 예외 메시지 확인
        assertEquals("충전 금액은 0보다 커야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("포인트 단위 확인")
    void exceptionUnitAmount() {
        // 10원 단위맞는 지 확인
        String userId = "abc";
        long amount = 125L;

        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId(userId);
        fakePoint.setPointTotal(BigDecimal.valueOf(1000));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pointService.chargeUserPoint(userId, BigDecimal.valueOf(amount))
        );

        assertEquals("충전 금액은 10원 단위여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("포인트 최대값확인(백만원까지만충전)")
    void exceptionMaxAmount() {
        // 최대값 백만이 넘을 경우 확인
        String userId = "abc";
        long amount = 1_000_010L;

        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId(userId);
        fakePoint.setPointTotal(BigDecimal.valueOf(1000));

        // 현재 포인트 조회 mock
        //when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);

        // when & then: 예외가 발생하는지 확인
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> pointService.chargeUserPoint(userId, BigDecimal.valueOf(amount))
        );

        // 예외 메시지 확인
        assertEquals("충전 가능한 최대 포인트는 1000000입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("포인트 충전하고 히스토리업데이트까지")
    void chargeUserPoint() {
        String userId = "abc";
        long amount = 9000L;

        // 현재 포인트 만들기
        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId(userId);
        fakePoint.setPointTotal(BigDecimal.valueOf(1000));

        // 포인트를 더해서 업데이트
        long newPoint = 1000L + amount;

        // 포인트 업데이트
        PointEntity newFakePoint = new PointEntity();
        newFakePoint.setUserId(userId);
        newFakePoint.setPointTotal(BigDecimal.valueOf(newPoint));

        // 충전된 내역을 히스토리에 인서트
        PointHistoryEntity fakeHistory = new PointHistoryEntity();
        fakeHistory.setUserId(userId);
        fakeHistory.setAmount(BigDecimal.valueOf(newPoint));
        fakeHistory.setType(TransactionType.CHARGE);
        fakeHistory.setCurrentTime(LocalDateTime.now());

        // 포인트 조회 시
        when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);
        when(pointRepository.save(any(PointEntity.class))).thenReturn(newFakePoint);

        // 결과는 새로 업데이트된 포인트가 조회돼야 한다.
        PointEntity result = pointService.chargeUserPoint(userId, BigDecimal.valueOf(amount));
        assertEquals(newPoint, result.getPointTotal());

        // 포인트 히스토리 인서트
        verify(pointHistoryRepository).save(any(PointHistoryEntity.class));

        // 포인트 히스토리 조회
        when(pointHistoryRepository.findByUserId(userId)).thenReturn(List.of(fakeHistory));

        // 유저아이디로 히스토리를 조회한다.
        List<PointHistoryEntity> resultHistory = pointService.getUserPointHistory(userId);

        // 조회한 내용을 비교한다.
        assertEquals(1, resultHistory.size());
        assertEquals(newPoint, resultHistory.get(0).getAmount());
        assertEquals(TransactionType.CHARGE, resultHistory.get(0).getType());
    }

}
