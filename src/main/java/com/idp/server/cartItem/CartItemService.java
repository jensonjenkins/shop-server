package com.idp.server.cartItem;

import com.idp.server.dto.CartItemDto;
import com.idp.server.dto.UpdateSessionDto;
import com.idp.server.session.Session;
import com.idp.server.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItem() {
        return cartItemRepository.getCartItem();
    }

    public List<CartItem> getMyCartItem(UpdateSessionDto updateSessionDto) {
        return cartItemRepository.getMyCartItem(updateSessionDto.getSessionId());
    }

    public ResponseEntity<String> addToCart(CartItemDto cartItemDto) {
        Long sessionId = cartItemDto.getSessionId();
        Long productId = cartItemDto.getProductId();
        int quantity = cartItemDto.getQuantity();

        Optional<CartItem> cartItemOptional = cartItemRepository.getCartItemByBothIds(sessionId, productId);
        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            quantity += cartItem.getQuantity();
            cartItemRepository.deleteById(cartItem.getId());
        }
        cartItemRepository.save(new CartItem(sessionId, productId, quantity));
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
