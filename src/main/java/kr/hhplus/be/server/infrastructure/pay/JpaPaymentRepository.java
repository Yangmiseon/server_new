package kr.hhplus.be.server.infrastructure.pay;

import kr.hhplus.be.server.domain.pay.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepository extends JpaRepository<PaymentEntity, String> {
    PaymentEntity findByOrderId(String orderId);
}
