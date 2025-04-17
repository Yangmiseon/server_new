package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.domain.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentFacade {

    private final PaymentService paymentService;

    public PaymentEntity placePay(OrderEntity order) {

        //결제
        paymentService.confirmPayment(order.getOrderId());
        return null;
    }
}
