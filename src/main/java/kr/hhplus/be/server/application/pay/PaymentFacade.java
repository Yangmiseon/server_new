package kr.hhplus.be.server.application.pay;

import kr.hhplus.be.server.application.base.UserService;
import kr.hhplus.be.server.application.coupon.CouponService;
import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.domain.pay.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class PaymentFacade {

    private final PaymentService paymentService;
    private final CouponService couponService;
    private final UserService userService;

    public PaymentEntity placePay(String orderId, String userId) {

        //쿠폰여부 확인하기
        String couponYn = userService.findByUserId(userId);

        //쿠폰 정보 조회
        CouponEntity coupon = couponService.getCoupon(userId);

        //결제하기
        if(coupon == null) {
            paymentService.confirmPayment(orderId);
        }else{
            paymentService.confirmPaymentCoupon(orderId,coupon);
        }


        // 결제생성


        return null;//완료리턴보내기
    }
}
