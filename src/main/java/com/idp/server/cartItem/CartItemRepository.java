package com.idp.server.cartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT * FROM cart_item", nativeQuery = true)
    List<CartItem> getCartItem();
}
