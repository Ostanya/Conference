package com.epam.rd.java.finalconf.dao.connection;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BConnection {
    private static BasicDataSource bds;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static final int DEFAULT_MAX_IDLE = 10;
    private static final int DEFAULT_MIN_IDLE = 5;
    private static final int DEFAULT_MAX_OPEN_PREPARED_STATEMENTS = 20;

    static {
        registerDriver();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        URL = resourceBundle.getString("database.url");
        USER = resourceBundle.getString("database.user");
        PASSWORD = resourceBundle.getString("database.password");
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static BasicDataSource getDataSource() {
        if (bds == null) {
            synchronized (BConnection.class) {
                if (bds == null) {
                    bds = new BasicDataSource();
                    bds.setMaxIdle(DEFAULT_MAX_IDLE);
                    bds.setMinIdle(DEFAULT_MIN_IDLE);
                    bds.setMaxOpenPreparedStatements(DEFAULT_MAX_OPEN_PREPARED_STATEMENTS);
                    bds.setUrl(URL);
                    bds.setUsername(USER);
                    bds.setPassword(PASSWORD);
                }
            }
        }
        return bds;
    }
}
