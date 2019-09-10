package com.perfecttest.tms.servlet.projects;

import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.servlet.BaseServlet;
import com.perfecttest.tms.utils.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProjectServlet extends BaseServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProjectServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting create new project");
        Project project = getProject(req);
        String currentDate = DateTimeUtils.getCurrentDate();
        project.setCreateTime(currentDate);
        project.setUpdateTime(currentDate);
        User user = getCurrentUser(req);
        project.setUserId(user.getId());
        projectsDao.saveNewProject(project);
        servletUtils.sendOkResponseWithMessage(resp, "OK");
    }


}
