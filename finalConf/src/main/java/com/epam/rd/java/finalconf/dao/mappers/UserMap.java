package com.epam.rd.java.finalconf.dao.mappers;

import com.epam.rd.java.finalconf.entity.Role;
import com.epam.rd.java.finalconf.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMap implements ObjectMapper<User> {

    @Override
    public User extract(ResultSet resultSet) throws SQLException {
        return Optional.ofNullable(User.builder()
                .withId(resultSet.getLong("id"))
                .withFirstName(resultSet.getString("first_name"))
                .withSecondName(resultSet.getString("second_name"))
                .withUsername(resultSet.getString("usrname"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .build()).orElseThrow(SQLException::new);
    }

    @Override
    public List<User> extractAll(ResultSet resultSet) throws SQLException {
        List<User> list = new ArrayList<>();
        resultSet.beforeFirst();

        while(resultSet.next()) {
            User user = extract(resultSet);
            list.add(user);
        }
        return list;
    }
}
