package com.arpan.redis.repository;

import com.arpan.redis.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final RedisTemplate redisTemplate;

    public Product save(Product product) {
        redisTemplate.opsForHash().put("product", product.getId(), product);
        return product;
    }

    public List<Product> findAllProducts() {
        return (List<Product>) redisTemplate.opsForHash().values("product");
    }

    public Product findById(long id) {
        return (Product) redisTemplate.opsForHash().get("product", id);
    }

    public void deleteById(long id) {
        redisTemplate.opsForHash().delete("product", id);
    }
}
