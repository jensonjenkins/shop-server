package com.idp.server.orderItem;

import com.idp.server.cartItem.CartItemService;
import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.OrderListItemDto;
import com.idp.server.order.OrderTable;
import com.idp.server.order.OrderRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final CartItemService cartItemService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository, CartItemService cartItemService, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.cartItemService = cartItemService;
        this.orderRepository = orderRepository;
    }


    public List<OrderItem> getOrderItems() {
        return orderItemRepository.getOrderItems();
    }

    public List<OrderListItemDto> getOrderItemsBySessionId(Long sessionId) {
        List<Tuple> result = orderItemRepository.getOrderItemsBySessionId(sessionId);
        List<OrderListItemDto> response = new ArrayList<>();
        String name, imageLink;
        Integer quantity;
        double price;
        Long orderId;
        for (Tuple tuple : result) {
            orderId = tuple.get("order_id", Long.class);
            name = tuple.get("name", String.class);
            imageLink = tuple.get("image_link", String.class);
            quantity = tuple.get("quantity", Integer.class);
            price = tuple.get("price", Double.class);
            response.add(new OrderListItemDto(quantity, name, price, imageLink, orderId));
        }
        return response;
    }

    public ResponseEntity<String> postOrderItem(Long sessionId) {
        List<DisplayCartItemDto> myCartItems = cartItemService.getMyCartItem(sessionId);
        OrderTable orderTable = new OrderTable(sessionId);
        orderRepository.save(orderTable);
        for (DisplayCartItemDto cartItem : myCartItems) {
            orderItemRepository.save(new OrderItem(sessionId,
                    cartItem.getQuantity(), cartItem.getProductId(), orderTable.getId()));
        }
        System.out.println("OrderTable id: " + orderTable.getId());
        return new ResponseEntity<>("Order updated!", HttpStatus.OK);
    }
}
