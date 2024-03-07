package com.idp.server.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class ProductConfig {
    @Autowired
    ProductRepository repository;

    @Bean
    CommandLineRunner productCLRunner() {
        return args -> {
//            Product p1 = new Product("phone1",
//                    "iPhone",
//                    123.02,
//                    LocalDate.now(),
//                    1);
//            Product p2 = new Product("phone2",
//                    "samsung",
//                    432.02,
//                    LocalDate.now(),
//                    2);
//            Product p3 = new Product("phone3",
//                    "android",
//                    1232.02,
//                    LocalDate.now(),
//                    3);
//            Product p4 = new Product("phone6",
//                    "samsung",
//                    562.02,
//                    LocalDate.now(),
//                    2);
//            repository.saveAll(List.of(p1, p2, p3, p4));
        };
    }
}
