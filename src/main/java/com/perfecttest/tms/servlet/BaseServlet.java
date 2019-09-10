package com.perfecttest.tms.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perfecttest.tms.domain.Project;
import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.domain.User;
import com.perfecttest.tms.storage.cases.CasesDao;
import com.perfecttest.tms.storage.cases.impl.DBCasesDao;
import com.perfecttest.tms.storage.projects.ProjectsDao;
import com.perfecttest.tms.storage.projects.impl.DBProjectsDao;
import com.perfecttest.tms.storage.suites.SuitesDao;
import com.perfecttest.tms.storage.suites.impl.DBSuitesDao;
import com.perfecttest.tms.storage.users.UsersDao;
import com.perfecttest.tms.storage.users.impl.DBUsersDao;
import com.perfecttest.tms.utils.ServletUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class BaseServlet extends HttpServlet {
    protected ServletUtils servletUtils = new ServletUtils();
    protected ProjectsDao projectsDao = new DBProjectsDao();
    protected CasesDao casesDao = new DBCasesDao();
    protected SuitesDao suitesDao = new DBSuitesDao();
    protected UsersDao usersDao = new DBUsersDao();
    protected Gson gson = new GsonBuilder().create();

    protected User getCurrentUser(HttpServletRequest req) {
        return new User().withUserName("Mike Sidelnikov").withId(1).withAvailableProjects("1", "2", "3");//TODO: here to get user from request: cookie or smth else
    }

    protected Project getProject(HttpServletRequest req) {
        String body = servletUtils.getBody(req);
        return gson.fromJson(body, Project.class);
    }

    protected Suite getSuite(HttpServletRequest req) {
        String body = servletUtils.getBody(req);
        return gson.fromJson(body, Suite.class);
    }
}