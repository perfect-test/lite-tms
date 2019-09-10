package com.perfecttest.tms.storage.cases.impl;

import com.google.gson.reflect.TypeToken;
import com.perfecttest.tms.domain.*;
import com.perfecttest.tms.storage.BaseDBDao;
import com.perfecttest.tms.storage.cases.CasesDao;
import com.perfecttest.tms.storage.suites.impl.DBSuitesDao;
import com.perfecttest.tms.storage.utils.DBClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBCasesDao extends BaseDBDao implements CasesDao {


    private static final Logger LOGGER = LoggerFactory.getLogger(DBSuitesDao.class);

    @Override
    public List<Case> getCasesForSuite(int suiteId) {
        DBClient dbClient = getDbClient();
        try {

            String request = String.format("SELECT * FROM cases WHERE suite_id= '%s'", suiteId);
            LOGGER.info("Request to get all suites: " + request);
            ResultSet resultSet =
                    getDbClient().executeQuery(request);
            List<Case> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(
                        new Case()
                                .withId(resultSet.getInt("id"))
                                .withCreateTime(resultSet.getString("create_time"))
                                .withUpdateTime(resultSet.getString("update_time"))
                                .withCreateUserId(resultSet.getInt("create_user_id"))
                                .withUpdateUserId(resultSet.getInt("update_user_id"))
                                .withName(resultSet.getString("name"))
                                .withPreconditions(resultSet.getString("preconditions"))
                                .withDescription(resultSet.getString("description"))
                                .withSuiteId(resultSet.getInt("suite_id"))
                                .withSteps(getSteps(resultSet.getString("steps")))
                                .withReferences(getReferences(resultSet.getString("references")))
                                .withPriority(getPriority(resultSet.getString("priority")))
                                .withType(getType(resultSet.getString("type")))
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

    private List<CaseStep> getSteps(String steps) {
        if (steps != null) {
            return GSON.fromJson(steps, new TypeToken<List<CaseStep>>() {
            }.getType());
        }
        return null;
    }

    private List<CaseReference> getReferences(String references) {
        if (references != null) {
            return GSON.fromJson(references, new TypeToken<List<CaseReference>>() {
            }.getType());
        }
        return null;
    }

    private CasePriority getPriority(String priority) {
        if (priority != null) {
            return CasePriority.valueOf(priority);
        }
        return null;
    }

    private CaseType getType(String type) {
        if (type != null) {
            return CaseType.valueOf(type);
        }
        return null;
    }


}
