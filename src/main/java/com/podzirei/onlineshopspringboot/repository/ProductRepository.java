package com.podzirei.onlineshopspringboot.repository;

import com.podzirei.onlineshopspringboot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    Product findByName(String name);

    void update(Product product);

    boolean delete(int id);
}
