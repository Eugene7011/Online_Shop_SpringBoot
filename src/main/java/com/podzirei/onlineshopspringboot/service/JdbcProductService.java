package com.podzirei.onlineshopspringboot.service;

import com.podzirei.onlineshopspringboot.entity.Product;
import com.podzirei.onlineshopspringboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JdbcProductService implements ProductService {
    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void add(Product product) {
        product.setCreationDate(LocalDateTime.now());
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }
}
