package kr.hhplus.be.server.application.base;

import kr.hhplus.be.server.domain.base.ItemEntity;
import kr.hhplus.be.server.infrastructure.base.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService( ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //상품전체조회
    public List<ItemEntity> getItemEntityList(){
        return itemRepository.findAll();
    }
}
