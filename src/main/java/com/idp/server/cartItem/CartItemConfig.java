package com.idp.server.cartItem;

import com.idp.server.cartItem.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CartItemConfig {
    @Autowired
    CartItemRepository cartItemRepository;

    @Bean
    CommandLineRunner cartItemCLRunner() {
        return args -> {
//            cartItemRepository.deleteAll();
        };
    }
}
