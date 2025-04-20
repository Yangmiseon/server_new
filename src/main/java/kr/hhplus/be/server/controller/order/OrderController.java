package kr.hhplus.be.server.controller.order;

import kr.hhplus.be.server.application.order.OrderFacade;
import kr.hhplus.be.server.application.order.OrderRequestDto;
import kr.hhplus.be.server.application.order.OrderService;
import kr.hhplus.be.server.domain.order.OrderEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderFacade orderFacade;

    public OrderController (OrderService orderService, OrderFacade orderFacade){

        this.orderService=orderService;
        this.orderFacade=orderFacade;
    }

    //주문한건 조회
    @GetMapping("{userId}/list")
    public Optional<OrderEntity> select (@PathVariable String userId,
                                         @RequestParam String orderId){
        return orderService.findByIdAndUserId(userId,orderId);
    }

    //사용자의 주문목록조회
    @GetMapping("{userId}/allList")
    public List<OrderEntity> findByUserId(@PathVariable String userId){
        return orderService.findByUserId(userId);
    }

    //주문이 들어오면 오더 파사드로 넘긴다.
    @PostMapping("/status")
    public OrderEntity order (@RequestBody OrderRequestDto request){

        return orderFacade.placeOrder(request);
    }

}
