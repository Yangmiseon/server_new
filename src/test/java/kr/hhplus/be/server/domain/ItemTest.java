package kr.hhplus.be.server.domain;
import kr.hhplus.be.server.application.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ItemTest {
    @MockBean
    private ItemService itemService;

    @Test
    void itemList() {
        ItemEntity item1 = new ItemEntity();
        item1.setItemId("item01");
        item1.setItemName("a라인 반바지");
        item1.setItemPrice(36_000L);
        ItemEntity item2 = new ItemEntity();
        item2.setItemId("item01");
        item2.setItemName("a라인 청치마");
        item2.setItemPrice(38_000L);

        List<ItemEntity> fakeItemList = List.of(item1,item2);
        when(itemService.getItemEntityList()).thenReturn(fakeItemList);

        List<ItemEntity> result = itemService.getItemEntityList();

        assertEquals(2,result.size());
        assertEquals(36_000L, result.get(0).getItemPrice());
        assertEquals("a라인 반바지",result.get(0).getItemName());

    }
}

