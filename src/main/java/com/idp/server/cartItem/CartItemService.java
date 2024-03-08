package com.idp.server.cartItem;

import com.idp.server.dto.CartItemDto;
import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.UpdateSessionDto;
import com.idp.server.session.Session;
import com.idp.server.user.UserEntity;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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

    public List<DisplayCartItemDto> getMyCartItem(UpdateSessionDto updateSessionDto) {
        List<Tuple> result = cartItemRepository.getMyCartItem(updateSessionDto.getSessionId());
        List<DisplayCartItemDto> response = new ArrayList<>();
        String name, imageLink;
        Integer quantity;
        double price;
        for (Tuple tuple : result) {
            name = tuple.get("name", String.class);
            imageLink = tuple.get("image_link", String.class);
            quantity = tuple.get("quantity", Integer.class);
            price = tuple.get("price", Double.class);
            response.add(new DisplayCartItemDto(quantity, name, price, imageLink));
        }
        return response;
    }

    @Transactional
    public ResponseEntity<String> addToCart(CartItemDto cartItemDto) {
        Long sessionId = cartItemDto.getSessionId();
        Long productId = cartItemDto.getProductId();
        int quantity = cartItemDto.getQuantity();

        Optional<CartItem> cartItemOptional = cartItemRepository.getCartItemByBothIds(sessionId, productId);
        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            quantity += cartItem.getQuantity();
            cartItemRepository.updateQty(sessionId, quantity);
            return new ResponseEntity<>("Cart updated.", HttpStatus.OK);
        } else {
            cartItemRepository.save(new CartItem(sessionId, productId, quantity));
            return new ResponseEntity<>("New cart item created.", HttpStatus.OK);
        }
    }
}
