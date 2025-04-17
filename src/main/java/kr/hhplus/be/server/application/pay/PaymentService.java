package kr.hhplus.be.server.application;

import jakarta.transaction.Transactional;
import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.infrastructure.*;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
import kr.hhplus.be.server.infrastructure.order.OrderRepository;
import org.springframework.stereotype.Service;

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

    @Transactional
    public OrderEntity confirmPayment(String orderId) {
        return null;
    }


}
