package com.perfecttest.tms.utils;

import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServletUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletUtils.class);

    public void sendBadResponseWithMessage(HttpServletResponse resp, String message) throws ServletException, IOException {
        sendResponse(resp, message, HttpServletResponse.SC_BAD_REQUEST);
    }

    public void sendJsonResponse(HttpServletResponse resp, String message, int code) throws ServletException, IOException {
        LOGGER.info("Response message: " + message);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Content-type","application/json; charset=utf-8");
        resp.getWriter().write(message);
        resp.setStatus(code);
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    public void sendResponse(HttpServletResponse resp, String message, int code) throws ServletException, IOException {
        LOGGER.info("Response message: " + message);
        resp.getWriter().write(message);
        resp.setStatus(code);
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    public void sendOkResponseWithMessage(HttpServletResponse resp, String message) throws ServletException, IOException {
        sendResponse(resp, message, HttpServletResponse.SC_OK);
    }

    public String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURI();
    }

    public String getBody(HttpServletRequest req) {
        try {
            return IOUtils.toString(req.getReader());
        } catch (IOException e) {
            LOGGER.info("error while reading body : " + e.getMessage());
            return null;
        }
    }

    public void logRequest(HttpServletRequest req) {
        LOGGER.info(
                req.getMethod() +
                        " request to " +
                        getRequestUrl(req) +
                        " with params:\n" +
                        new GsonBuilder().create().toJson(req.getParameterMap())
        );
    }

    public String getHttpMethod(HttpServletRequest request) {
        return request.getMethod();
    }


    public List<RequestParameter> getRequestParameters(HttpServletRequest request){
        List<RequestParameter> parameters = new ArrayList<>();
        Map paramsMap = request.getParameterMap();
        for(Object key : paramsMap.keySet()){
            String keyString = (String)key;
            parameters.add(new RequestParameter(keyString, request.getParameter(keyString)));
        }
        return parameters;
    }

    public  List<String> getSplittedValue(String parameterName, List<RequestParameter> requestParameters) {
        RequestParameter parameter = getRequestParameter(parameterName, requestParameters);
        if (parameter != null) {
            return Arrays.asList(parameter.getValue().split(","));
        }
        return null;
    }

    public  String getParameterValue(String parameterName, List<RequestParameter> requestParameters) {
        RequestParameter parameter = getRequestParameter(parameterName, requestParameters);
        if (parameter != null) {
            return parameter.getValue();
        }
        return null;
    }

    public  RequestParameter getRequestParameter(String parameterName, List<RequestParameter> requestParameters) {
        for (RequestParameter requestParameter : requestParameters) {
            if (requestParameter.getName().equals(parameterName)) {
                return requestParameter;
            }
        }
        return null;
    }



}
