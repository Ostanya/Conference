package com.epam.rd.java.finalconf.dao.connection;

import com.epam.rd.java.finalconf.dao.UDao;
import com.epam.rd.java.finalconf.dao.UserDAO;
import com.epam.rd.java.finalconf.dao.mappers.UserMap;
import com.epam.rd.java.finalconf.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UDao{
    private Connection connection;
    private final UserMap userMap = new UserMap();

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findByUserEmail(String email) {
        try(PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_FIND_BY_USER_EMAIL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.ofNullable(userMap.extract(rs));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteByUserId(long id) {
        boolean status;
        try(PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_DELETE_USER_BY_ID)) {
            ps.setString(1, String.valueOf(id));
            status = ps.executeUpdate() > 0;
            if(status){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<User> updateRole(User user) {
        boolean status;
        try(PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_UPDATE_USER_ROLE)) {
            ps.setString(1, user.getRole().name());
            ps.setString(2, String.valueOf(user.getId()));
            status = ps.executeUpdate() > 0;
            if (status) {
                return Optional.of(user);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User user) {
        try(PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_UPDATE_USER)) {
            ps.setString(1, user.getUsername());
            ps.setString(1, String.valueOf(user.getId()));
            ps.setString(1, user.getFirstName());
            ps.setString(1, user.getLastName());
            ps.setString(1, user.getPassword());
            ps.setString(1, String.valueOf(user.getRole()));
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> findById(long id) {
        try(PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_FIND_BY_ID)) {
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.ofNullable(userMap.extract(rs));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(User user) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try (PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_FIND_ALL_USERS,
                             ResultSet.TYPE_SCROLL_INSENSITIVE,
                             ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return userMap.extractAll(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<User> save(User user) {
        try (PreparedStatement ps = connection.prepareStatement(UserDAO.SQL_SAVE_USER)){
            ps.setString(1, user.getUsername());
            ps.setString(1, String.valueOf(user.getId()));
            ps.setString(1, user.getFirstName());
            ps.setString(1, user.getLastName());
            ps.setString(1, user.getEmail());
            ps.setString(1, String.valueOf(user.getRole()));
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(user);
    }
}
