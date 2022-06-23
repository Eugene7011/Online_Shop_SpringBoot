package com.podzirei.onlineshopspringboot.web;

import com.podzirei.onlineshopspringboot.entity.Product;
import com.podzirei.onlineshopspringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        List<Product> products = productService.findAll();
        logger.info("products {}", products);

        //convert to json

        return products;
    }

    @PostMapping
    protected void addProduct(@RequestBody Product product) throws IOException {
        logger.info("add product {}", product);
        productService.add(product);

    }

    @GetMapping(path = "/{id}")
    public Product findById(@PathVariable int id) {
        Product product = productService.findById(id);
        logger.info("products {}", product);

        return product;
    }
}
