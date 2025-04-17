package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.application.OrderRequestDto;
import kr.hhplus.be.server.application.OrderService;
import kr.hhplus.be.server.domain.OrderEntity;
import kr.hhplus.be.server.domain.OrderType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController (OrderService orderService){
        this.orderService=orderService;
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

    @PostMapping("/status")
    public OrderEntity order (@RequestBody OrderRequestDto request){
        return orderService.request(request);
    }

}
