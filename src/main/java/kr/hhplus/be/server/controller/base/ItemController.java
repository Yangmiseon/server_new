package kr.hhplus.be.server.controller.base;

import kr.hhplus.be.server.application.base.ItemService;
import kr.hhplus.be.server.domain.base.ItemEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    //전체 상품 조회
    @GetMapping("/itemList")
    public List<ItemEntity> getItemEntityList(){
        return itemService.getItemEntityList();
    }
}
