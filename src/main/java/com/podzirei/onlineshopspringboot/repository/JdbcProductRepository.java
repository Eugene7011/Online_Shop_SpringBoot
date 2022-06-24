package com.podzirei.onlineshopspringboot.repository;

import com.podzirei.onlineshopspringboot.dao.jdbc.mapper.ProductRowMapper;
import com.podzirei.onlineshopspringboot.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements ProductRepository{

    private final ProductRowMapper productRowMapper = new ProductRowMapper();

    private static final String FIND_ALL_SQL = "SELECT id, name, price, creation_date FROM products;";
    private static final String ADD_SQL = "INSERT INTO products (name, price, creation_date) " +
            "VALUES (:name, :price, :date);";
    private static final String DELETE_SQL = "DELETE FROM products WHERE id=?;";
    private static final String UPDATE_SQL = "UPDATE products SET name=?, price=? WHERE id=?;";
    private static final String SEARCH_SQL_BY_ID = "SELECT id, name, price, creation_date FROM products WHERE id=?;";
    private static final String SEARCH_SQL_BY_NAME = "SELECT id, name, price, creation_date FROM products WHERE name=?;";

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, productRowMapper);
    }

    @Override
    public void add(Product product) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", product.getName());
        parameters.put("price", product.getPrice());
        parameters.put("creation_date", product.getCreationDate());

        namedParameterJdbcTemplate.update(ADD_SQL, parameters);
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject(SEARCH_SQL_BY_ID, productRowMapper, id);
    }

    @Override
    public Product findByName(String name) {
        return jdbcTemplate.queryForObject(SEARCH_SQL_BY_NAME, productRowMapper, name);
    }

    @Override
    public void update(Product product) {

        jdbcTemplate.update(UPDATE_SQL,
                    product.getName(),
                    product.getPrice(),
                    product.getId());
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update(DELETE_SQL, id) > 0;
    }
}
