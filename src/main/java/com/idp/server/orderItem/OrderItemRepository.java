package com.idp.server.orderItem;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query(value = "SELECT * FROM order_item", nativeQuery = true)
    List<OrderItem> getOrderItems();

    @Query(value = "SELECT order_id, product_id, quantity, name, price, image_link " +
            "FROM session, order_item, product " +
            "WHERE product.id = order_item.product_id " +
            "AND session.id = order_item.session_id " +
            "AND session.id = ?1", nativeQuery = true)
    List<Tuple> getOrderItemsBySessionId(Long sessionId);
}
