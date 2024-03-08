package com.idp.server.product;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService produceService) {
        this.productService = produceService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
