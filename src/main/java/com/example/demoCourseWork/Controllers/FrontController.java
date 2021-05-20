package com.example.demoCourseWork.Controllers;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontController", urlPatterns = "/lots/*")
public class FrontController extends HttpServlet {
    private StrategySelector strategySelector;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.strategySelector = (StrategySelector) config.getServletContext().getAttribute("selector");
    }

    private String getPath (HttpServletRequest reqest) {
        String answer = reqest.getPathInfo();
        if(answer == null) answer = "/";
        return answer;
    }

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        strategySelector.getStrategy(getPath(reqest)).dewGet(reqest, response);
    }

    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        strategySelector.getStrategy(getPath(reqest)).dewPost(reqest, response);
    }
}
