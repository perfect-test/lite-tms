package com.perfecttest.tms.servlet.suites;

import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.servlet.BaseServlet;
import com.perfecttest.tms.utils.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateSuiteServlet extends BaseServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateSuiteServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting create new suite");
        Suite suite = getSuite(req);
        String currentDate = DateTimeUtils.getCurrentDate();
        suite.setCreateTime(currentDate);
        suite.setUpdateTime(currentDate);
        User user = getCurrentUser(req);
        suite.setCreateUserId(user.getId());
        suite.setUpdateUserId(user.getId());
        suitesDao.createNewSuite(suite);
        servletUtils.sendOkResponseWithMessage(resp, "OK");
    }


}

