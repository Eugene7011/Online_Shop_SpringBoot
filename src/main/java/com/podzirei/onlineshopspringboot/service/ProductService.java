package com.podzirei.onlineshopspringboot.service;

import com.podzirei.onlineshopspringboot.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);
}
