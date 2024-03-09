package com.idp.server.session;

import com.idp.server.dto.UpdateSessionDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Session getSessionById(Long sessionId) {
        Optional<Session> session = sessionRepository.findById(sessionId);
        return session.orElse(null);
    }
}
