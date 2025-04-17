package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    ItemEntity findByItemId(String itemId);
    ItemEntity findByItemIdAndItemQuantity(String itemId, int quantity);

}

