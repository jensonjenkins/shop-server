package com.idp.server.orderItem;

import com.idp.server.cartItem.CartItemService;
import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartItemService cartItemService;

    public OrderService(OrderRepository orderRepository, CartItemService cartItemService) {
        this.orderRepository = orderRepository;
        this.cartItemService = cartItemService;
    }

    @Autowired


    public List<OrderItem> getOrderItems() {
        return orderRepository.getOrderItems();
    }

    public List<OrderItem> getOrderItemsBySessionId(Long sessionId) {
        return orderRepository.getOrderItemsBySessionId(sessionId);
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
