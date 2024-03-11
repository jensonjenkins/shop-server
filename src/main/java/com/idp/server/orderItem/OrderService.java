package com.idp.server.orderItem;

import com.idp.server.cartItem.CartItemService;
import com.idp.server.dto.DisplayCartItemDto;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartItemService cartItemService) {
        this.orderRepository = orderRepository;
        this.cartItemService = cartItemService;
    }


    public List<OrderItem> getOrderItems() {
        return orderRepository.getOrderItems();
    }

    public List<DisplayCartItemDto> getOrderItemsBySessionId(Long sessionId) {
        List<Tuple> result = orderRepository.getOrderItemsBySessionId(sessionId);
        List<DisplayCartItemDto> response = new ArrayList<>();
        String name, imageLink;
        Integer quantity;
        double price;
        Long productId;
        for (Tuple tuple : result) {
            productId = tuple.get("product_id", Long.class);
            name = tuple.get("name", String.class);
            imageLink = tuple.get("image_link", String.class);
            quantity = tuple.get("quantity", Integer.class);
            price = tuple.get("price", Double.class);
            response.add(new DisplayCartItemDto(quantity, name, price, imageLink, productId));
        }
        return response;
    }

    public ResponseEntity<String> postOrderItem(Long sessionId) {
        List<DisplayCartItemDto> myCartItems = cartItemService.getMyCartItem(sessionId);
        for (DisplayCartItemDto cartItem : myCartItems) {
            orderRepository.save(new OrderItem(sessionId,
                    cartItem.getQuantity(), cartItem.getProductId()));
        }
        return new ResponseEntity<>("Order updated!", HttpStatus.OK);
    }
}
