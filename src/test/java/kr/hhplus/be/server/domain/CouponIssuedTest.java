package kr.hhplus.be.server.domain;


import kr.hhplus.be.server.application.coupon.CouponService;
import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import kr.hhplus.be.server.infrastructure.coupon.CouponSpecRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CouponIssuedTest {
    @Mock
    private CouponService couponService;

    @Mock
    private CouponSpecRepository couponSpecRepository;

    @Test
    void couponIssued() {
        String couponSpecId = "test-coupon-id";
        String userId = "test-user";

        CouponSpecEntity spec = new CouponSpecEntity();
        spec.setCouponTotalQuantity(100); //
        couponSpecRepository.save(spec);

        // given: 발급 결과 Mock 동작 지정
        CouponEntity fakeIssuedCoupon = new CouponEntity();
        fakeIssuedCoupon.setUserId(userId);
        when(couponService.IssuedCoupon(userId, couponSpecId)).thenReturn(fakeIssuedCoupon);

        // when: 발급 호출
        CouponEntity result = couponService.IssuedCoupon(userId, couponSpecId);

        // then: 값 검증
        assertEquals(userId, result.getUserId());

        // 호출 여부 검증
        verify(couponService, times(1)).IssuedCoupon(userId, couponSpecId);
    }


    }


