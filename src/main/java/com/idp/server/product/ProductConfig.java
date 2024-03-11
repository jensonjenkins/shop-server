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

//            Product p1 = new Product("iPhone15",
//                    "iPhone15 - The latest flagship smartphone from Apple with an advanced camera system and blazing-fast performance."
//                    ,
//                    1299.99, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/02_1024x1024.jpg?v=1705218056",
//                    999);
//
//            Product p2 = new Product("Airpods Max",
//                    "Airpods Max - A powerful and stylish smartphone with cutting-edge technology and a stunning display."
//                    ,
//                    299.99, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/pp3_360x.jpg?v=1705217052",
//                    999);
//
//            Product p3 = new Product("iPad",
//                    "iPad - The ultimate portable device for work, play, and creativity, featuring a beautiful Retina display and support for Apple Pencil."
//                    ,
//                    399.99, LocalDate.now(), "tablet",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/09_540x.jpg?v=1705218596",
//                    999);
//
//            Product p4 = new Product("MacbookAir2023",
//                    "MacBook Air 2023 - The next-generation MacBook Air with an ultra-slim design, powerful M-series chip, and all-day battery life."
//                    ,
//                    1299.99, LocalDate.now(), "laptop",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/15_360x.jpg?v=1705219307",
//                    999);
//
//            Product p5 = new Product("Samsung phone",
//                    "Samsung Red Phone - A sleek and stylish smartphone from Samsung, featuring a vibrant red color and advanced camera technology."
//                    ,
//                    199.99, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/05_540x.jpg?v=1705218241",
//                    999);
//
//            Product p6 = new Product("Samsung phone",
//                    "Samsung White Phone - Another fantastic smartphone from Samsung, featuring a stunning blue finish and innovative features."
//                    ,
//                    249.99, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/30_540x.jpg?v=1701772622",
//                    999);
//
//            Product p7 = new Product("Speaker",
//                    "Speaker - Enjoy high-quality sound with this stylish and compact speaker, perfect for listening to music at home or on the go."
//                    ,
//                    99.99, LocalDate.now(), "accessory",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/pp2_540x.jpg?v=1705216981",
//                    999);
//
//            Product p8 = new Product("Ultrawatch",
//                    "Ultrawatch - Stay connected and track your fitness goals with this advanced smartwatch, featuring a sleek design and comprehensive health monitoring."
//                    ,
//                    199.99, LocalDate.now(), "watch",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/07_540x.jpg?v=1705218390",
//                    999);
//
//            Product p9 = new Product("Watch OffWhite",
//                    "Watch Off White - Elevate your style with this elegant timepiece from Off White, featuring a luxurious design and precision craftsmanship."
//                    ,
//                    299.99, LocalDate.now(), "watch",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/08_31d71816-3918-4f65-b033-9db3900ab202_540x.jpg?v=1705219598",
//                    999);
//
//            Product p10 = new Product("Xiaomi phone",
//                    "Xiaomi Phone - The latest smartphone from Xiaomi with powerful features and sleek design."
//                    ,
//                    399.99, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/19_bbf200a5-0200-4226-9783-a4dd2faa9007_540x.jpg?v=1705219860",
//                    999);
//            Product p11 = new Product("N420 Headphones",
//                    "N420 Headphones - High-end headphones with premium sound quality and comfortable design."
//                    ,
//                    999.00, LocalDate.now(), "headphones",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/11_540x.jpg?v=1705218855",
//                    999);
//            Product p12 = new Product("Oneplus 6t Mirror Phone",
//                    "Oneplus 6T Mirror Phone - A stylish and powerful smartphone with a reflective mirror finish."
//                    ,
//                    259.00, LocalDate.now(), "phone",
//                    "https://quickstep007.myshopify.com/cdn/shop/files/24_1024x1024.jpg?v=1701772818",
//                    999);
//
//            repository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11,
//                    p12));
        };
    }
}
