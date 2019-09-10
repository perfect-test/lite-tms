package com.perfecttest.tms.servlet.suites;

import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.servlet.BaseServlet;
import com.perfecttest.tms.servlet.projects.UpdateProjectServlet;
import com.perfecttest.tms.utils.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSuiteServlet extends BaseServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateProjectServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting update new project");
        Suite suite = getSuite(req);
        suite.setUpdateTime(DateTimeUtils.getCurrentDate());
        User user = getCurrentUser(req);
        suite.setUpdateUserId(user.getId());
        suitesDao.updateSuite(suite);
        servletUtils.sendOkResponseWithMessage(resp, "OK");
    }

}
