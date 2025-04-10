package kr.hhplus.be.server;

import kr.hhplus.be.server.domain.PointEntity;
import kr.hhplus.be.server.domain.PointHistoryEntity;
import kr.hhplus.be.server.application.PointService;
import kr.hhplus.be.server.infrastructure.PointRepository;
import kr.hhplus.be.server.infrastructure.PointHistoryRepository;
import kr.hhplus.be.server.domain.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	private PointService pointService;  // 진짜 대상

	@MockBean
	private PointRepository pointRepository;  // 의존성은 Mock

	@MockBean
	private PointHistoryRepository pointHistoryRepository;


	@Test
	void testPointTotal() {
		String userId = "abc";
		PointEntity fakePoint = new PointEntity();
		fakePoint.setUserId(userId);
		fakePoint.setPointTotal(1000L);

		// 유저아이디로 포인트를 조회할때
		when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);

		// 결과는 1000이 조회돼야 한다.
		long result = pointService.getUserPoint(userId);

		// 조회되는값이 1000과 같은가?
		assertEquals(1000L, result);
	}

	@Test
	void testPointHistory() {
		// given
		String userId = "abc";

		PointHistoryEntity history1 = new PointHistoryEntity();
		history1.setUserId(userId);
		history1.setType(TransactionType.CHARGE);
		history1.setAmount(1000);
		history1.setCurrentTime(new Date());

		PointHistoryEntity history2 = new PointHistoryEntity();
		history2.setUserId(userId);
		history2.setType(TransactionType.USE);
		history2.setAmount(500);
		history2.setCurrentTime(new Date());

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
	void exceptionMaxAmount() {
		// given
		String userId = "abc";
		long amount = 1_000_001L;

		PointEntity fakePoint = new PointEntity();
		fakePoint.setUserId(userId);
		fakePoint.setPointTotal(1000L);

		// 현재 포인트 조회 mock
		when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);

		// when & then: 예외가 발생하는지 확인
		IllegalArgumentException exception = assertThrows(
				IllegalArgumentException.class,
				() -> pointService.chargeUserPoint(userId, amount)
		);

		// 예외 메시지 확인
		assertEquals("충전 가능한 최대 포인트는 1000000입니다.", exception.getMessage());
	}

	@Test
	void chargeUserPoint() {
		String userId = "abc";
		long amount = 9000L;

		// 현재 포인트 만들기
		PointEntity fakePoint = new PointEntity();
		fakePoint.setUserId(userId);
		fakePoint.setPointTotal(1000L);

		// 포인트를 더해서 업데이트
		long newPoint = 1000L + amount;

		// 포인트 업데이트
		PointEntity newFakePoint = new PointEntity();
		newFakePoint.setUserId(userId);
		newFakePoint.setPointTotal(newPoint);

		// 충전된 내역을 히스토리에 인서트
		PointHistoryEntity fakeHistory = new PointHistoryEntity();
		fakeHistory.setUserId(userId);
		fakeHistory.setAmount(newPoint);
		fakeHistory.setType(TransactionType.CHARGE);
		fakeHistory.setCurrentTime(new Date());

		// 포인트 조회 시
		when(pointRepository.findByUserId(userId)).thenReturn(fakePoint);
		doReturn(newFakePoint).when(pointRepository).insertAndUpdate(userId, newPoint);

		// 결과는 새로 업데이트된 포인트가 조회돼야 한다.
		PointEntity result = pointService.chargeUserPoint(userId, amount);
		assertEquals(newPoint, result.getPointTotal());

		// 포인트 히스토리 인서트
		doReturn(fakeHistory).when(pointHistoryRepository)
				.insert(eq(userId), eq(newPoint), eq(TransactionType.CHARGE), any(LocalDateTime.class));

		// 포인트 히스토리 조회
		when(pointHistoryRepository.findByUserId(userId)).thenReturn(List.of(fakeHistory));

		// 유저아이디로 히스토리를 조회한다.
		List<PointHistoryEntity> resultHistory = pointService.getUserPointHistory(userId);

		// 조회한 내용을 비교한다.
		assertEquals(1, resultHistory.size());
		assertEquals(newPoint, resultHistory.get(0).getAmount());
		assertEquals(TransactionType.CHARGE, resultHistory.get(0).getType());

	}



	@Test
	void contextLoads() {
	}

}
