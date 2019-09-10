package com.perfecttest.tms.storage.suites;

import com.perfecttest.tms.domain.Suite;

import java.util.List;

public interface SuitesDao {

    List<Suite> getSuitesForProject(int projectId);

    void deleteSuite(int suiteId);

    void updateSuite(Suite suite);

    void createNewSuite(Suite suite);
}
