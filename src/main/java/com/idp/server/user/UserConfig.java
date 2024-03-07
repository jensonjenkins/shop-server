package com.idp.server.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Autowired
    UserRepository userRepository;

    @Bean
    CommandLineRunner userCLRunner() {
        return args -> {
//            UserEntity u1 = new UserEntity("jenson@email",
//                    "12345",
//                    "jenson",
//                    "jenkins",
//                    "01239758374");
//            userRepository.save(u1);
        };
    }
}
