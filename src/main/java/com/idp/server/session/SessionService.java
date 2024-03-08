package com.idp.server.session;

import com.idp.server.dto.UpdateSessionDto;
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

    public ResponseEntity<String> updateSession(UpdateSessionDto updateSessionDto) {
        Long sessionId = updateSessionDto.getSessionId();
        Long userId;
        double addToPrice = updateSessionDto.getPrice();
        double newPrice;
        Optional<Session> optionalSession = sessionRepository.findById(sessionId);
        if (optionalSession.isPresent()) {
            Session session = optionalSession.get();
            userId = session.getUserId();
            newPrice = session.getTotal() + addToPrice;
            sessionRepository.deleteById(sessionId);
            sessionRepository.save(new Session(userId, newPrice));
            return new ResponseEntity<>("Session Successfully Updated!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Session Not Found!", HttpStatus.BAD_REQUEST);
        }
    }
}
