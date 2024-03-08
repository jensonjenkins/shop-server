package com.idp.server.cartItem;

import com.idp.server.dto.DisplayCartItemDto;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM cart_item", nativeQuery = true)
    List<CartItem> getCartItem();

    @Query(value = "SELECT quantity, name, price, image_link " +
            "FROM session, cart_item, product " +
            "WHERE product.id = cart_item.product_id " +
            "AND session.id = cart_item.session_id " +
            "AND session.id = ?1", nativeQuery = true)
    List<Tuple> getMyCartItem(Long sessionId);

    @Query(value = "SELECT * FROM cart_item WHERE cart_item.session_id = ?1 AND cart_item.product_id = ?2", nativeQuery = true)
    Optional<CartItem> getCartItemByBothIds(Long sessionId, Long productId);

    @Modifying
    @Query(value = "UPDATE cart_item SET quantity = ?2 WHERE cart_item.session_id = ?1", nativeQuery = true)
    void updateQty(Long sessionId, Integer qty);
}
