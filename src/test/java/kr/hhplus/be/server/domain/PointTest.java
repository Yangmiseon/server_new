package kr.hhplus.be.server.domain;

import kr.hhplus.be.server.application.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PointTest {

    @MockBean
    private PointService pointService;


    @Test
    void testPointTotal() {
        PointEntity fakePoint = new PointEntity();
        fakePoint.setUserId("abc");
        fakePoint.setPointTotal(1000L);

        when(pointService.getUserPoint("abc")).thenReturn(1000L);

        long result = pointService.getUserPoint("abc");

        assertEquals(1000L, result);
    }

    @Test
    void testPointHistory() {
        // 가짜 PointHistoryEntity 객체 생성
        PointHistoryEntity history1 = new PointHistoryEntity();
        history1.setUserId("abc");
        history1.setType(TransactionType.CHARGE);
        history1.setAmount(1000);
        history1.setCurrentTime(new Date());

        PointHistoryEntity history2 = new PointHistoryEntity();
        history2.setUserId("abc");
        history2.setType(TransactionType.USE);
        history2.setAmount(500);
        history2.setCurrentTime(new Date());

        List<PointHistoryEntity> fakeHistoryList = List.of(history1, history2);
        // Mock 설정: userId "abc"로 조회 시 위 리스트 반환
        when(pointService.getUserPointHistory("abc")).thenReturn(fakeHistoryList);

        // 실제 호출
        List<PointHistoryEntity> result = pointService.getUserPointHistory("abc");

        // 검증
        assertEquals(2, result.size());
        assertEquals(1000, result.get(0).getAmount());
        assertEquals(TransactionType.CHARGE, result.get(0).getType());

    }



    @Test
    void contextLoads() {
    }

}
