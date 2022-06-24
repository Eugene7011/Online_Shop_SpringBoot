package com.podzirei.onlineshopspringboot.web;

import com.podzirei.onlineshopspringboot.entity.Product;
import com.podzirei.onlineshopspringboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        logger.info("products {}", products);

        return products;
    }

    @PostMapping(path = "/add")
    protected void addProduct(@RequestBody Product product) {
        logger.info("add product {}", product);
        productService.add(product);
    }

    @GetMapping(path = "/{id}")
    public Product findById(@PathVariable int id) {
        Product product = productService.findById(id);
        logger.info("findById {}", product);

        return product;
    }

    @GetMapping(path = "/search/{name}")
    public Product findByName(@PathVariable String name) {
        Product product = productService.findByName(name);
        logger.info("findByName {}", product);

        return product;
    }

    @PutMapping(path = "/update")
    protected void updateProduct(@RequestBody Product product) {
        logger.info("update {}", product);
        productService.update(product);
    }

    @DeleteMapping(path = "/delete/{id}")
    protected boolean deleteProduct(@PathVariable int id) {
        logger.info("delete {}", id);
        return productService.delete(id);
    }
}
