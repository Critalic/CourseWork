package com.example.demoCourseWork.Controllers.Decorators;


import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenderWithIdRequestDecorator extends ProcessRequestDecorator {

    private final LotService lotService;
    public TenderWithIdRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("tender",
                    lotService.getLotById(request.getParameter("tenderId"))
            );
            request.setAttribute("user", request.getSession().getAttribute("user"));
            forwardToJsp(request, response, "tender");
        } catch (NoIDException | NullPointerException e) {
            response.sendRedirect(request.getContextPath()+"/tenders/");
        } catch (DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
    }
}
