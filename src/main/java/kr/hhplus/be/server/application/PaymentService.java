package kr.hhplus.be.server.domain;

import kr.hhplus.be.server.infrastructure.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ItemRepository itemRepository;
    public PaymentService(PaymentRepository paymentRepository, ItemRepository itemRepository) {
        this.paymentRepository = paymentRepository;
        this.itemRepository = itemRepository;
    }

    public PaymentEntity canPayment(PaymentEntity payment) {
        //1. 재고 확인한다.
        if (payment.getItemQ {
            return payment;
        }
        //2. 금액을 확인한다.
        if()
    }
}
