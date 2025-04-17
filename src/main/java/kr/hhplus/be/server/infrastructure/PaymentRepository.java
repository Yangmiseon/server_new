package kr.hhplus.be.server.domain;

public interface PaymentRepository {
    PaymentEntity findById(String itemId);
}
