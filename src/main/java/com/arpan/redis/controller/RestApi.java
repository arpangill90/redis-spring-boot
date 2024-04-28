package com.arpan.redis.controller;

import com.arpan.redis.entity.Product;
import com.arpan.redis.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class RestApi {

    private final ProductRepository productRepository;

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> findAllProducts() {
//        Product product = new Product();
//        product.setId(122l);
//        product.setName("apple");
//        product.setPrice(20.88);
//        return List.of(product);
        return productRepository.findAllProducts();
    }
}
