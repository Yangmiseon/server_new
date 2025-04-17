package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.OrderEntity;
import kr.hhplus.be.server.domain.OrderType;
import kr.hhplus.be.server.domain.PointEntity;
import kr.hhplus.be.server.infrastructure.OrderRepository;
import kr.hhplus.be.server.infrastructure.PointRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PointRepository pointRepository;

    public OrderService(OrderRepository orderRepository,PointRepository pointRepository){
        this.orderRepository=orderRepository;
        this.pointRepository=pointRepository;
    }

    //주문생성
    public OrderEntity request(OrderRequestDto request){
        if (request.getType() != OrderType.REQUESTED) {//리퀘스트에서 받은 요청이 주문요청아니면
            throw new IllegalArgumentException("주문요청이 아닙니다.");
        }
        //주문요청이 맞으면 사용금액과 전체금액 비교
        BigDecimal pointUsed = pointRepository.findByUserId(request.getUserId()).getPointTotal();
        BigDecimal totalPrice = request.getTotalPrice();

        if(pointUsed.compareTo(totalPrice) < 0){//pointUsed<totalPrice 이거랑 같음
            throw new IllegalArgumentException("사용포인트가 부족해 주문 할 수 없습니다. 충전 후 이용해주세요.");
        }
        OrderEntity order = new OrderEntity();
        order.setType(request.getType()); //주문 타입
        order.setUserId(request.getUserId()); //주문요청자
        order.setPointUsed(pointUsed); //사용자가 현재 가지고 있는 포인트
        order.setTotalPrice(totalPrice); //결제해야 하는 금액
        order.setOrderCurrentTime(LocalDateTime.now()); //주문시간

        return orderRepository.save(order);
    }

    //주문한건
    public Optional<OrderEntity> findByIdAndUserId(String orderId, String userId){
        return orderRepository.findByIdAndUserId(orderId,userId);
    }

    //사용자의 주문목록 조회
    public List<OrderEntity> findByUserId(String userId){
        return orderRepository.findByUserIdOrderByOrderCurrentTimeDesc(userId);
    }
}
