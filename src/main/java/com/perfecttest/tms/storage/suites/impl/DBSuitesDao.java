package com.perfecttest.tms.storage.suites.impl;

import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.storage.BaseDBDao;
import com.perfecttest.tms.storage.suites.SuitesDao;
import com.perfecttest.tms.storage.utils.DBClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBSuitesDao extends BaseDBDao implements SuitesDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBSuitesDao.class);

    @Override
    public List<Suite> getSuitesForProject(int projectId) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format("SELECT * FROM suites WHERE project_id = '%s'", projectId);
            LOGGER.info("Request to get all suites: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);
            List<Suite> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(
                        new Suite()
                                .withId(resultSet.getInt("id"))
                                .withCreateTime(resultSet.getString("create_time"))
                                .withUpdateTime(resultSet.getString("update_time"))
                                .withCreateUserId(resultSet.getInt("create_user_id"))
                                .withUpdateUserId(resultSet.getInt("update_user_id"))
                                .withName(resultSet.getString("name"))
                                .withShortDescription(resultSet.getString("short_description"))
                                .withDescription(resultSet.getString("description"))
                                .withProjectId(resultSet.getInt(projectId))

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
    public void deleteSuite(int suiteId) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "DELETE FROM suites WHERE id=%s",
                    suiteId
            );

            LOGGER.info("Delete suite from db started.. Request: " + request);
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
    public void updateSuite(Suite suite) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "UPDATE suites SET update_time=%s, update_user_id='%s', name='%s', short_description='%s', description='%s' WHERE id=%s",
                    getValueForDb(suite.getUpdateTime()),
                    suite.getUpdateUserId(),
                    suite.getName(),
                    suite.getShortDescription(),
                    suite.getDescription(),
                    suite.getId()
            );

            LOGGER.info("Update suite in db started.. Request: " + request);
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
    public void createNewSuite(Suite suite) {
        DBClient dbClient = getDbClient();
        try {
            String request = String.format(
                    "INSERT INTO `suites` (`create_time`, `update_time`, `create_user_id`, `update_user_id`, `name`, `short_description`, `description`, `project_id`)" +
                            "VALUES" +
                            "(%s, %s, '%s',  '%s', '%s', '%s','%s', '%s')",
                    getValueForDb(suite.getCreateTime()),
                    getValueForDb(suite.getUpdateTime()),
                    suite.getCreateUserId(),
                    suite.getUpdateUserId(),
                    suite.getName(),
                    suite.getShortDescription(),
                    suite.getDescription(),
                    suite.getProjectId()
            );
            LOGGER.info("Insert suite in db started.. Request: " + request);
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
