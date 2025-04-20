package kr.hhplus.be.server.application.pay;

import jakarta.transaction.Transactional;
import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.domain.pay.PaymentEntity;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
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

    public PaymentService(PaymentRepository paymentRepository, ItemRepository itemRepository,OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public OrderEntity confirmPayment(String orderId, CouponEntity coupon) {
        String type = coupon.getType().toString();
        BigDecimal discount = coupon.getCouponDiscount();
        OrderEntity order = orderRepository.findByOrderIdOnly(orderId);
        BigDecimal total = order.getTotalPrice().multiply(discount);
        PaymentEntity payment = new PaymentEntity();

        payment.setOrderId(orderId);
        return null;
    }


}
