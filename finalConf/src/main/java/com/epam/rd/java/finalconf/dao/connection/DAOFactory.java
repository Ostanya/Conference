package com.epam.rd.java.finalconf.dao.connection;


import static com.epam.rd.java.finalconf.dao.connection.BConnection.getConnection;

public class DAOFactory {
     public static UserDaoImpl createUserDao(){ return new UserDaoImpl(getConnection());}
}
