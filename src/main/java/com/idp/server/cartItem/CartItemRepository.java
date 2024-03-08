package com.idp.server.cartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM cart_item", nativeQuery = true)
    List<CartItem> getCartItem();

    @Query(value = "SELECT * FROM cart_item WHERE cart_item.session_id = ?1", nativeQuery = true)
    List<CartItem> getMyCartItem(Long sessionId);

    @Query(value = "SELECT * FROM cart_item WHERE cart_item.session_id = ?1 AND cart_item.product_id = ?2", nativeQuery = true)
    Optional<CartItem> getCartItemByBothIds(Long sessionId, Long productId);
}
