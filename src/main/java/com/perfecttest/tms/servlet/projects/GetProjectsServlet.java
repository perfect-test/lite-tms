package com.perfecttest.tms.servlet.projects;


import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.servlet.BaseServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetProjectsServlet extends BaseServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetProjectsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting get all projects");
        List<Project> projects = projectsDao.getAllProjects();
        User user = getCurrentUser(req);
        List<Project> result = new ArrayList<>();
//        if (user.getAvailableProjects() != null) {
            for (Project project : projects) {
//                if (user.getAvailableProjects().contains(String.valueOf(project.getId()))) {
                    result.add(project);
//                }
            }
//        }
        String response = gson.toJson(result);
        LOGGER.info(String.format("get_projects response: %s", response));
        servletUtils.sendJsonResponse(resp, response, HttpServletResponse.SC_OK);
    }

}
