package com.idp.server.session;

import com.idp.server.cartItem.CartItemRepository;
import com.idp.server.dto.UpdateSessionDto;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository, CartItemRepository cartItemRepository) {
        this.sessionRepository = sessionRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<Session> getSessions() {
        return sessionRepository.getSessions();
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
    public Session getSessionById(Long sessionId) {
        double total = getTotal(sessionId);
        sessionRepository.updateTotal(sessionId, total);
        Optional<Session> session = sessionRepository.findById(sessionId);
        return session.orElse(null);
    }
}
