package com.idp.server.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository
        extends JpaRepository<Session, Long> {
    @Query(value = "SELECT * FROM session", nativeQuery = true)
    List<Session> getSessions();

    @Query(value = "SELECT * FROM session WHERE session.user_id = ?1", nativeQuery = true)
    Session findByUserId(Long userId);

    @Modifying
    @Query(value = "UPDATE session SET total = ?2 where session.id = ?1", nativeQuery = true)
    void updateTotal(Long userId, double newPrice);
}
