package com.perfecttest.tms.storage.projects.impl;

import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.storage.BaseDBDao;
import com.perfecttest.tms.storage.projects.ProjectsDao;
import com.perfecttest.tms.storage.utils.DBClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBProjectsDao extends BaseDBDao implements ProjectsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBProjectsDao.class);

    @Override
    public List<Project> getAllProjects() {
        DBClient dbClient = getDbClient();
        try {
            String request = "SELECT * FROM projects";
            LOGGER.info("Request to get all projects: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);
            List<Project> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(
                        new Project()
                                .withId(resultSet.getInt("id"))
                                .withCreateTime(resultSet.getString("create_time"))
                                .withUpdateTime(resultSet.getString("update_time"))
                                .withUserId(resultSet.getInt("user_id"))
                                .withName(resultSet.getString("name"))
                                .withShortDescription(resultSet.getString("short_description"))
                                .withDescription(resultSet.getString("description"))
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

    @Override
    public Project getProjectById(int id) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format("SELECT * FROM projects WHERE id='%s'", id);
            LOGGER.info("Request to get project by id: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);

            if (resultSet.next()) {
                return new Project()
                        .withId(resultSet.getInt("id"))
                        .withCreateTime(resultSet.getString("create_time"))
                        .withUpdateTime(resultSet.getString("update_time"))
                        .withUserId(resultSet.getInt("user_id"))
                        .withName(resultSet.getString("name"))
                        .withShortDescription(resultSet.getString("short_description"))
                        .withDescription(resultSet.getString("description"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }
    }

    @Override
    public void saveNewProject(Project project) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "INSERT INTO `projects` (`create_time`, `update_time`, `user_id`, `name`, `short_description`, `description`)" +
                            "VALUES" +
                            "(%s, %s, '%s',  '%s', '%s', '%s')",
                    getValueForDb(project.getCreateTime()),
                    getValueForDb(project.getUpdateTime()),
                    project.getUserId(),
                    project.getName(),
                    project.getShortDescription(),
                    project.getDescription());
            LOGGER.info("Insert project in db started.. Request: " + request);
            getDbClient().executeUpdateQuery(
                    request
            );
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }
    }

    private String getValueForDb(String value) {
        if (value != null) {
            return "'" + value + "'";
        }
        return null;
    }

    @Override
    public void updateProject(Project project) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "UPDATE projects SET update_time=%s, user_id='%s', name='%s', short_description='%s', description='%s' WHERE id=%s",
                    getValueForDb(project.getUpdateTime()),
                    project.getUserId(),
                    project.getName(),
                    project.getShortDescription(),
                    project.getDescription(),
                    project.getId()
            );

            LOGGER.info("Update project in db started.. Request: " + request);
            getDbClient().executeUpdateQuery(
                    request
            );
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }

    }

    @Override
    public void deleteProject(Project project) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "DELETE FROM projects WHERE id=%s",
                    project.getId()
            );

            LOGGER.info("Delete project from db started.. Request: " + request);
            getDbClient().executeUpdateQuery(
                    request
            );
        } finally {
            if (dbClient != null) {
                dbClient.close();
            }
        }
    }
}
