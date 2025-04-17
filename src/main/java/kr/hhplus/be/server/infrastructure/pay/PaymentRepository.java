package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PaymentEntity;

public interface PaymentRepository {
    PaymentEntity findByOrderId(String orderId);
    PaymentEntity save(PaymentEntity payment);
}
