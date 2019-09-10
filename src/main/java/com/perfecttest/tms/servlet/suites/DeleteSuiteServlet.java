package com.perfecttest.tms.servlet.suites;

import com.perfecttest.tms.domain.Suite;
import com.perfecttest.tms.servlet.BaseServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSuiteServlet extends BaseServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteSuiteServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUtils.logRequest(req);
        LOGGER.info("Starting delete suite");
        suitesDao.deleteSuite(getSuite(req).getId());
        servletUtils.sendOkResponseWithMessage(resp, "OK");
    }

}
