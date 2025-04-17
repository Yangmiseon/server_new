package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepository extends JpaRepository<PaymentEntity, String> {
    PaymentEntity findByOrderId(String orderId);
}
