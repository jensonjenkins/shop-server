package com.idp.server.orderItem;

import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.OrderItemDto;
import com.idp.server.dto.OrderListItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/orderItem")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {
    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public List<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }

    @PostMapping("/getBySessionId")
    List<OrderListItemDto> getOrderItemsBySessionId(@RequestBody OrderItemDto orderItemDto) {
        return orderItemService.getOrderItemsBySessionId(orderItemDto.getSessionId());
    }

    @PostMapping("/save")
    ResponseEntity<String> postOrderItems(@RequestBody OrderItemDto orderItemDto) {
        return orderItemService.postOrderItem(orderItemDto.getSessionId());
    }
}
