package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.application.pay.PaymentFacade;
import kr.hhplus.be.server.application.point.PointService;
import kr.hhplus.be.server.domain.order.OrderEntity;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class OrderFacade {
    private final OrderService orderService;
    private final PointService pointService;
    private final PaymentFacade paymentFacade;
    private final OrderItemService orderItemService;

    //여기서는 주문을 해도 되는지 검증하고, 주문을 생성한다.
    public OrderEntity placeOrder(OrderRequestDto request) {
        // 요청 타입 검증
        orderService.validateRequestType(request.getType());

        // 사용자 포인트 조회
        BigDecimal point = pointService.getUserPoint(request.getUserId());

        // 주문 금액 계산
        BigDecimal total = orderItemService.calculateTotalPrice(request.getItems());

        // 주문금액만큼 포인트 있는지 확인
        pointService.validateEnough(point, total);

        //주문생성및 저장
        OrderEntity order = orderService.createOrderItems(request, point, total);

        //결제요청호출
        paymentFacade.placePay(order.getOrderId(),order.getUserId());

        // 주문이 생성 및 저장되면 생성된 주문 반환
        return order;
    }

}
