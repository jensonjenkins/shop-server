package com.idp.server.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository
        extends JpaRepository<Session, Long> {
    @Query(value = "SELECT * FROM session", nativeQuery = true)
    List<Session> getSessions();
}
