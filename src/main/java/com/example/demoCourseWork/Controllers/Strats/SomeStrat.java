package com.example.demoCourseWork.Controllers.Strats;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SomeStrat {

    protected void forwardToJsp(HttpServletRequest request, HttpServletResponse response, String jspName)
            throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/WEB-INF/JSPPages/").append(jspName).append(".jsp");
        request.getRequestDispatcher(stringBuilder.toString()).forward(request, response);
    }

    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

    }

    public void dewPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
