package kr.hhplus.be.server;

import kr.hhplus.be.server.application.coupon.CouponService;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import kr.hhplus.be.server.infrastructure.coupon.CouponSpecRepository;
import kr.hhplus.be.server.infrastructure.coupon.JpaCouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CouponToUserTest {
    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponSpecRepository couponSpecRepository;

    @Autowired
    private JpaCouponRepository jpaCouponRepository;

    @Test
    void couponToUserTest() throws InterruptedException{
        // given: 쿠폰 스펙 등록 (수량 100)
        CouponSpecEntity spec = new CouponSpecEntity();
        spec.setCouponTotalQuantity(100);
        spec.setCouponSpecName("멀티스레드테스트쿠폰");
        couponSpecRepository.save(spec);
        String couponSpecId = spec.getCouponSpecId();

        // when: 100명의 유저가 동시에 발급 요청
        int threadCount = 100;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final String userId = "user" + i;
            executor.submit(() -> {
                try {
                    couponService.IssuedCoupon(userId, couponSpecId);
                } catch (Exception e) {
                    System.out.println("실패한 유저: " + userId + ", 이유: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 모든 스레드 완료될 때까지 대기

        // then: 쿠폰은 정확히 100개 발급됐어야 함
        long issuedCount = jpaCouponRepository.count();
        CouponSpecEntity updatedSpec = couponSpecRepository.findById(couponSpecId).orElseThrow();

        System.out.println("발급된 쿠폰 수: " + issuedCount);
        System.out.println("남은 수량: " + updatedSpec.getCouponTotalQuantity());

        assertEquals(100, issuedCount);
        assertEquals(0, updatedSpec.getCouponTotalQuantity());
    }
}
