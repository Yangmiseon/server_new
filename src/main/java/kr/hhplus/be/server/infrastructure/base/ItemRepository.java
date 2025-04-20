package kr.hhplus.be.server.infrastructure.base;

import kr.hhplus.be.server.domain.base.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {
    ItemEntity findByItemId(String itemId);
    ItemEntity findByItemIdAndItemQuantity(String itemId, int quantity);

}

