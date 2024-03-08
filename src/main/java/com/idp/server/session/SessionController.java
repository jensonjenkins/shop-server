package com.idp.server.session;

import com.idp.server.dto.UpdateSessionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> getSession() {
        return sessionService.getSessions();
    }

    @PostMapping
    public ResponseEntity<String> updateSession(@RequestBody UpdateSessionDto updateSessionDto) {
        return sessionService.updateSession(updateSessionDto);
    }
}
