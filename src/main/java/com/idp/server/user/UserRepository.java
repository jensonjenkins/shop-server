package com.idp.server.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<UserEntity> getUsers();

    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
