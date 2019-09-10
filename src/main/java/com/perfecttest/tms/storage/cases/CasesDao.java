package com.perfecttest.tms.storage.cases;

import com.perfecttest.tms.domain.Case;

import java.util.List;

public interface CasesDao {

    List<Case> getCasesForSuite(int suiteId);
}
