package com.epam.rd.java.finalconf.dao.impl;

import com.epam.rd.java.finalconf.dao.UserDao;
import com.epam.rd.java.finalconf.dao.mappers.UserMap;
import com.epam.rd.java.finalconf.db.Queries;
import com.epam.rd.java.finalconf.entity.User;
import com.epam.rd.java.finalconf.util.exeption.UserExistExept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserDaoImpl implements UserDao {
    private Connection connection;
    private final UserMap userMapper = new UserMap();

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<User> findById(long id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.FIND_BY_ID_QUERY)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.ofNullable(userMapper.extract(rs));
            }
        } catch (SQLException e) {
            //log.warn("ERROR: can't provide user findById operation!", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (PreparedStatement statement = connection.prepareStatement(Queries.FIND_BY_USER_EMAIL_QUERY)) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.ofNullable(userMapper.extract(rs));
            }
        } catch (SQLException e) {
            //log.warn("ERROR: can't provide user findByEmail operation!", e);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(long id) {
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.DELETE_USER_BY_ID)) {
            statement.setLong(1, id);
            boolean isDeleted = statement.executeUpdate() > 0;
            if (isDeleted) {
              //  log.info("Deleted user id: {}", id);
                return true;
            }
        } catch (SQLException e) {
           // log.error("ERROR: can't provide user delete operation!", e);
        }
        return false;
    }


    @Override
    public List<User> findAll() {
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.FIND_ALL_USERS_QUERY,
                             ResultSet.TYPE_SCROLL_INSENSITIVE,
                             ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return userMapper.extractAll(rs);
            }
        } catch (SQLException e) {
           // log.error("ERROR: can't provide user findAll operation!", e);
        }
        return new ArrayList<>();
    }

    @Override
    public Optional<User> save(User user) {
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.SAVE_USER_QUERY)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole().name());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex1) {
           // log.warn("Attempt to create existing user [email: {}]", user.getEmail());
            throw new UserExistExept("Such user already exists: " + user.getEmail());
        } catch (SQLException e) {
          //  log.error("ERROR: can't provide user save operation!", e);
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> update(User user) {
        try (PreparedStatement statement =
                     connection.prepareStatement(Queries.UPDATE_USER_QUERY)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.isEnabled());
            statement.setString(5, user.getRole().name());
            statement.setLong(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
           // log.error("ERROR: can't provide user update operation!", e);
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> updateUserRole(User user) {
        try(PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_USER_BY_ROLE_QUERY)) {
            ps.setString(1, user.getRole().name());
            ps.setLong(2, user.getId());
            boolean isUpdated = ps.executeUpdate() > 0;
            if (isUpdated) {
                return Optional.of(user);
            }
        } catch (SQLException e) {
           // log.info("Can not provide user update by role operation", e);
        }
        return Optional.empty();
    }


    @Override
    public Optional<User> delete(User user) {
        return Optional.empty();
    }
}
