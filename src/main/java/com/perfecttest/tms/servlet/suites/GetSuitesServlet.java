package com.perfecttest.tms.servlet.suites;

import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.servlet.BaseServlet;
import com.perfecttest.tms.servlet.projects.GetProjectsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetSuitesServlet extends BaseServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(GetProjectsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting get all suites");
        List<Suite> projects = suitesDao.getSuitesForProject(getProjectId(req));
        String response = gson.toJson(projects);
        LOGGER.info(String.format("get_suites response: %s", response));
        servletUtils.sendJsonResponse(resp, response, HttpServletResponse.SC_OK);
    }

    private int getProjectId(HttpServletRequest req) {
        return Integer.valueOf(req.getParameter("projectId"));
    }

}
