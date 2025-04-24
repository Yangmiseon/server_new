package kr.hhplus.be.server.infrastructure.pay;

import kr.hhplus.be.server.domain.pay.PaymentEntity;

public interface PaymentRepository {
    PaymentEntity findByOrderId(String orderId);
    PaymentEntity save(PaymentEntity payment);
}
