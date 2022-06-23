package com.podzirei.onlineshopspringboot.dao.jdbc.mapper;

import com.podzirei.onlineshopspringboot.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper {
    public User mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String login = resultSet.getString("login");
        String hashedPassword = resultSet.getString("hashed_password");
        String salt = resultSet.getString("salt");

        return User.builder()
                .id(id)
                .login(login)
                .password(hashedPassword)
                .salt(salt)
                .build();
    }
}
