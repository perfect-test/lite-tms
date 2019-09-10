package com.perfecttest.tms.servlet.projects;

import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.servlet.BaseServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetProjectServlet extends BaseServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetProjectServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting get project");
        Project project = projectsDao.getProjectById(getProjectId(req));
        if (project != null) {
            String response = gson.toJson(project);
            LOGGER.info(String.format("get_project response: %s", response));
            servletUtils.sendJsonResponse(resp, response, HttpServletResponse.SC_OK);
        } else {
            LOGGER.info("Project not found");
            servletUtils.sendJsonResponse(resp, "", HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private int getProjectId(HttpServletRequest req) {
        return Integer.valueOf(req.getParameter("projectId"));
    }

}
