package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.order.OrderEntity;
import kr.hhplus.be.server.domain.order.OrderItemEntity;
import kr.hhplus.be.server.domain.order.OrderType;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
import kr.hhplus.be.server.infrastructure.order.OrderRepository;
import kr.hhplus.be.server.infrastructure.point.PointRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PointRepository pointRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, PointRepository pointRepository, ItemRepository itemRepository){
        this.orderRepository=orderRepository;
        this.pointRepository=pointRepository;
        this.itemRepository = itemRepository;
    }

    //주문요청확인
    public void validateRequestType(OrderType type) {
        if (type  != OrderType.REQUESTED) {
            throw new IllegalArgumentException("주문요청이 아닙니다.");
        }
    }

    public OrderEntity createOrderItems(OrderRequestDto request, BigDecimal point, BigDecimal total) {
        //주문생성
        OrderEntity order = new OrderEntity();
        order.setType(OrderType.REQUESTED);
        order.setUserId(request.getUserId());
        order.setOrderCurrentTime(LocalDateTime.now());
        order.setPointUsed(point);
        order.setTotalPrice(total);

        // 주문 상품 리스트 생성
        List<OrderItemEntity> orderItems = request.getItems().stream()
                .map(dto -> {
                    OrderItemEntity item = new OrderItemEntity();
                    item.setItemId(dto.getItemId());
                    item.setOrderItemQuantity(dto.getQuantity());
                    item.setOrder(order); // 연관관계 설정
                    return item;
                })
                .toList();

        // 주문에 상품 추가
        order.setOrderItems(orderItems);

        // 저장
        return orderRepository.save(order);
    }



    //사용자의 주문 한건 조회
    public Optional<OrderEntity> findByIdAndUserId(String orderId, String userId){
        return orderRepository.findByIdAndUserId(orderId,userId);
    }

    //사용자의 주문목록 조회
    public List<OrderEntity> findByUserId(String userId){
        return orderRepository.findByUserIdOrderByOrderCurrentTimeDesc(userId);
    }
}
