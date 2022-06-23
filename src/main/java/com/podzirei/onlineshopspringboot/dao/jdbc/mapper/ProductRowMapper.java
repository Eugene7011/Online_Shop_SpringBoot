package com.podzirei.onlineshopspringboot.dao.jdbc.mapper;

import com.podzirei.onlineshopspringboot.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRowMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet resultSet, int numRow) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name").trim();
        double price = resultSet.getDouble("price");

        Timestamp creationDateTimesTemp = resultSet.getTimestamp("creation_date");

        return Product.builder().
                id(id)
                .name(name)
                .price(price)
                .creationDate(creationDateTimesTemp.toLocalDateTime())
                .build();
    }
}




