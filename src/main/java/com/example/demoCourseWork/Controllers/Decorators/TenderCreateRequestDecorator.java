package com.example.demoCourseWork.Controllers.Decorators;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenderCreateRequestDecorator extends ProcessRequestDecorator {

    private LotService lotService;
    public TenderCreateRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String about = request.getParameter("about").trim();

        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            forwardToJsp(request, response,"login");
            return;
        }

        try {
            lotService.createNewLot(name, user.getLogin(), about);
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", e.getLocalizedMessage());
            forwardToJsp(request,  response, "newTender");
            return;
        } catch (DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/tenders/");
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        forwardToJsp(request, response, "newTender");
    }
}
