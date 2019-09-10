package com.perfecttest.tms.servlet.cases;

import com.perfecttest.tms.domain.Case;
import com.perfecttest.tms.servlet.BaseServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCasesServlet extends BaseServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetCasesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        int suiteId = getSuiteId(req);
        LOGGER.info(String.format("Starting get cases for suite with id `%s`", suiteId));
        List<Case> cases = casesDao.getCasesForSuite(suiteId);
        String response = gson.toJson(cases);
        LOGGER.info(String.format("get_cases response: %s", response));
        servletUtils.sendJsonResponse(resp, response, HttpServletResponse.SC_OK);
    }

    private int getSuiteId(HttpServletRequest req) {
        return Integer.valueOf(req.getParameter("suiteId"));
    }

}
