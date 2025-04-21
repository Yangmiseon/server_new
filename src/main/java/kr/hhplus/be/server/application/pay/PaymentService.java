package kr.hhplus.be.server.application.pay;

import jakarta.transaction.Transactional;
import kr.hhplus.be.server.application.coupon.CouponService;
import kr.hhplus.be.server.application.point.PointService;
import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.coupon.CouponType;
import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.domain.pay.PaymentEntity;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
import kr.hhplus.be.server.infrastructure.coupon.CouponRepository;
import kr.hhplus.be.server.infrastructure.order.OrderRepository;
import kr.hhplus.be.server.infrastructure.pay.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CouponService couponService;
    private final PointService pointService;

    public PaymentService(
            PaymentRepository paymentRepository,
            ItemRepository itemRepository,
            OrderRepository orderRepository, CouponService couponService, PointService pointService) {
        this.paymentRepository = paymentRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.couponService = couponService;
        this.pointService = pointService;
    }
    //쿠폰있을 때
    public OrderEntity confirmPaymentCoupon(String orderId, CouponEntity coupon) {
        OrderEntity order = orderRepository.findByOrderIdOnly(orderId);//오더불러오기
        BigDecimal totalPrice = order.getTotalPrice(); //전체금액
        CouponType type = coupon.getType(); // 쿠폰타입
        int discount = coupon.getCouponDiscount(); // 쿠폰할인값(%or금액)
        //최종금액
        BigDecimal finalPrice = couponService.calculateDiscountedPrice(type,totalPrice,discount);
        //할인 된 금액
        BigDecimal discountTotal = finalPrice.multiply(BigDecimal.valueOf(discount));
        // 포인트금애
        pointService.getUserPoint(coupon.getUserId());
        PaymentEntity payment = new PaymentEntity();
        payment.setUserCouponUseYN("Y"); //쿠폰사용
        payment.setUserCouponId(coupon.getCouponId()); //사용쿠폰아이디
        payment.setBalancePoint();
        return null;
    }

    //쿠폰없을 때
    public OrderEntity confirmPayment(String orderId) {
        OrderEntity order = orderRepository.findByOrderIdOnly(orderId);
        return null;
    };


}
