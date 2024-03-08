package com.idp.server.session;

import com.idp.server.dto.UpdateSessionDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getSessions() {
        return sessionRepository.getSessions();
    }

    @Transactional
    public Session updateSession(UpdateSessionDto updateSessionDto) {
        Long sessionId = updateSessionDto.getSessionId();
        Long userId;
        double addToPrice = updateSessionDto.getPrice();
        double newPrice;
        Optional<Session> optionalSession = sessionRepository.findById(sessionId);
        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            userId = session.getUserId();
            newPrice = session.getTotal() + addToPrice;
            sessionRepository.updateTotal(userId, newPrice);
            return session;
        } else {
            return null;
        }
    }
}
