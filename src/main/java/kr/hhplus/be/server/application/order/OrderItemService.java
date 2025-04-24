package kr.hhplus.be.server.application.order;

import kr.hhplus.be.server.domain.base.ItemEntity;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
import kr.hhplus.be.server.infrastructure.order.OrderItemRepository;
import kr.hhplus.be.server.infrastructure.point.PointRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemService {

    private OrderItemRepository orderItemRepository;
    private PointRepository pointRepository;
    private ItemRepository itemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public BigDecimal calculateTotalPrice(List<OrderItemRequestDto> items) {
        return items.stream()
                .map(dto -> {
                    ItemEntity item = itemRepository.findByItemId(dto.getItemId());
                    return BigDecimal.valueOf(item.getItemPrice())
                            .multiply(BigDecimal.valueOf(dto.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
