package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.application.ItemService;
import kr.hhplus.be.server.domain.ItemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(PointController.class);
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
