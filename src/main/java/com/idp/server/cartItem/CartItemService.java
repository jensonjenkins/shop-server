package com.idp.server.cartItem;

import com.idp.server.dto.CartItemDto;
import com.idp.server.dto.DisplayCartItemDto;
import com.idp.server.dto.UpdateSessionDto;
import com.idp.server.session.Session;
import com.idp.server.session.SessionRepository;
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
    private final SessionRepository sessionRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, SessionRepository sessionRepository) {
        this.cartItemRepository = cartItemRepository;
        this.sessionRepository = sessionRepository;
    }

    public List<CartItem> getCartItem() {
        return cartItemRepository.getCartItem();
    }

    public List<DisplayCartItemDto> getMyCartItem(Long sessionId) {
        List<Tuple> result = cartItemRepository.getMyCartItem(sessionId);
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

    public double getTotal(Long sessionId) {
        List<Tuple> result = cartItemRepository.getMyCartItem(sessionId);
        Integer quantity;
        double price, total = 0.0;
        for (Tuple tuple : result) {
            quantity = tuple.get("quantity", Integer.class);
            price = tuple.get("price", Double.class);
            total += quantity * price;
        }
        return total;
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
            cartItemRepository.updateQty(sessionId, productId, quantity);
            double total = getTotal(sessionId);
            sessionRepository.updateTotal(sessionId, total);
            return new ResponseEntity<>("Cart updated.", HttpStatus.OK);
        } else {
            cartItemRepository.save(new CartItem(sessionId, productId, quantity));
            double total = getTotal(sessionId);
            sessionRepository.updateTotal(sessionId, total);
            return new ResponseEntity<>("New cart item created.", HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<String> deleteAllBySessionId(Long sessionId) {
        cartItemRepository.deleteAllBySessionId(sessionId);
        return new ResponseEntity<>("All cart item deleted.", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<String> deleteOneItem(Long sessionId, Long productId) {
        cartItemRepository.deleteOneItem(sessionId, productId);
        return new ResponseEntity<>("Item successfully removed.", HttpStatus.OK);
    }
}
