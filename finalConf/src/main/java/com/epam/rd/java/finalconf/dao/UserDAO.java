package com.epam.rd.java.finalconf.dao;

public class UserDAO {
    private static UserDAO userDao;
    public static final String SQL_FIND_BY_ID = "SELECT * FROM users WHERE users.id = ?";
    public static final String SQL_FIND_BY_USER_EMAIL= "SELECT * FROM users WHERE users.email = ?";
    public static final String SQL_SAVE_USER = "INSERT INTO users (first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?)";
    public static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    public static final String SQL_UPDATE_USER= "UPDATE users SET first_name = ?, last_name = ?, password = ?, enabled = ?, role = ? WHERE id = ?";
    public static final String SQL_UPDATE_USER_ROLE= "UPDATE users set role = ? WHERE id = ?";
    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";

    private UserDAO() {}

    public static UserDAO getInstance() {
        if(userDao == null) {
            userDao = new UserDAO();
        }
        return userDao;
    }
}
