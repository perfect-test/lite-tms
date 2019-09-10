package com.perfecttest.tms.storage.users.impl;

import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.storage.BaseDBDao;
import com.perfecttest.tms.storage.users.UsersDao;
import com.perfecttest.tms.storage.utils.DBClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DBUsersDao extends BaseDBDao implements UsersDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBUsersDao.class);

    @Override
    public User getUserById(int id) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format("SELECT * FROM users WHERE id=%s", id);
            LOGGER.info("Request to get user by id: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);
            User result = null;
            if (resultSet.next()) {
                result = new User()
                        .withId(resultSet.getInt("id"))
                        .withUserName(resultSet.getString("user_name"))
                        .withAvailableProjects(getAvailableProjects(resultSet.getString("available_projects")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }
    }

    private List<String> getAvailableProjects(String availableProjectsString) {
        if (availableProjectsString != null) {
            return Arrays.asList(availableProjectsString.split(","));
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        DBClient dbClient = getDbClient();
        try {
            String request = "SELECT * FROM users";
            LOGGER.info("Request to get all users: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);
            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(
                        new User()
                                .withId(resultSet.getInt("id"))
                                .withUserName(resultSet.getString("user_name"))
                                .withAvailableProjects(getAvailableProjects(resultSet.getString("available_projects")))
                );
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }
    }
}
