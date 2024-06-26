package com.idp.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUser() {
        return userRepository.getUsers();
    }

    public UserEntity saveUser(UserEntity newUser) {
        userRepository.save(newUser);
        return newUser;
    }
}
