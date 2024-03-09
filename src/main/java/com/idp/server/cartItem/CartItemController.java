package com.idp.server.cartItem;

import com.idp.server.dto.CartItemDto;
import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.UpdateSessionDto;
import jakarta.persistence.Tuple;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/cart_item")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItem> getCartItem() {
        return cartItemService.getCartItem();
    }

    @PostMapping("/my_cart")
    public List<DisplayCartItemDto> getMyCartItem(@RequestBody UpdateSessionDto updateSessionDto) {
        return cartItemService.getMyCartItem(updateSessionDto.getSessionId());
    }

    @PostMapping
    public ResponseEntity<String> addToCart(@RequestBody CartItemDto cartItemDto) {
        return cartItemService.addToCart(cartItemDto);
    }

    @DeleteMapping(value = "/all")
    public ResponseEntity<String> deleteAllBySessionId(@RequestBody UpdateSessionDto updateSessionDto) {
        return cartItemService.deleteAllBySessionId(updateSessionDto.getSessionId());
    }
}
