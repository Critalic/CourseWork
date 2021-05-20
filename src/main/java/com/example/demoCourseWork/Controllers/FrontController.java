package com.example.demoCourseWork.Controllers;

import com.example.demoCourseWork.Controllers.Factory.RequestDecoratorFactory;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/tenders/*"})
public class FrontController extends HttpServlet {

    private RequestDecoratorFactory factory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        factory = (RequestDecoratorFactory) config.getServletContext().getAttribute("factory");
    }

    private String getPathFromRequest(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) { pathInfo = "/"; }
        return pathInfo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        factory.getDecoratorForPath(getPathFromRequest(request))
                .executeGet(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        factory.getDecoratorForPath(getPathFromRequest(request))
                .executePost(request, response);

    }
}