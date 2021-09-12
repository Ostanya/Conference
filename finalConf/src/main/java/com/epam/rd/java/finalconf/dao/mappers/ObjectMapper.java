package com.epam.rd.java.finalconf.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ObjectMapper<T> {
    T extract(ResultSet resultSet) throws SQLException;
    List<T> extractAll(ResultSet resultSet) throws SQLException;
}
