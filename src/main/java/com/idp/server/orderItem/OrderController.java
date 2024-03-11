package com.idp.server.orderItem;

import com.idp.server.dto.OrderItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderItem> getOrderItems() {
        return orderService.getOrderItems();
    }

    @PostMapping("/getBySessionId")
    List<OrderItem> getOrderItemsBySessionId(@RequestBody OrderItemDto orderItemDto) {
        return orderService.getOrderItemsBySessionId(orderItemDto.getSessionId());
    }

    @PostMapping("/save")
    ResponseEntity<String> postOrderItems(@RequestBody OrderItemDto orderItemDto) {
        return orderService.postOrderItem(orderItemDto.getSessionId());
    }
}
