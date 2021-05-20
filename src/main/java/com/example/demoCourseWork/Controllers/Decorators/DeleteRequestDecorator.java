package com.example.demoCourseWork.Controllers.Decorators;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRequestDecorator extends ProcessRequestDecorator {

    private final LotService lotService;

    public DeleteRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DBError, NoIDException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                forwardToJsp(request, response, "login");
                return;
            }
            String lotId = request.getParameter("lotId");
            if (lotId.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/lots/");
                return;
            }
            lotService.deleteLot(lotId, user.getLogin());
            response.sendRedirect(request.getContextPath() + "/tenders/");
        } catch (NoIDException e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
    }
}
