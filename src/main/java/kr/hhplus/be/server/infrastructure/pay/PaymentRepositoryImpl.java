package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private JpaPaymentRepository jpaPaymentRepository;
    public PaymentRepositoryImpl(JpaPaymentRepository jpaPaymentRepository) {
        this.jpaPaymentRepository = jpaPaymentRepository;
    }

    @Override
    public PaymentEntity findByOrderId(String orderId) {
        return jpaPaymentRepository.findByOrderId(orderId);
    }

    @Override
    public PaymentEntity save(PaymentEntity payment){
        return jpaPaymentRepository.save(payment);
    }
}
