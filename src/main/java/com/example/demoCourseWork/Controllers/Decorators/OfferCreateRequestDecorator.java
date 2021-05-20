package com.example.demoCourseWork.Controllers.Decorators;



import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OfferCreateRequestDecorator extends ProcessRequestDecorator {

    private LotService lotService;

    public OfferCreateRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("message", null);
            forwardToJsp(request, response, "login");
            return;
        }

        try {
            String tenderId = request.getParameter("tenderId");
            lotService.createNewOffer(
                    request.getParameter("text"),
                    request.getParameter("money"),
                    tenderId,
                    user.getLogin()
            );
            response.sendRedirect(request.getContextPath()+"/tenders/tender?tenderId="+tenderId);
        } catch (IllegalArgumentException e){
            request.setAttribute("errorMessage", e.getLocalizedMessage());
            request.setAttribute("tenderId", request.getParameter("tenderId"));
            forwardToJsp(request,  response, "newOffer");
        } catch (NoIDException | NullPointerException | DBError e) {
            response.sendRedirect(request.getContextPath()+"/tenders/");
        }

    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user")!=null){
            request.setAttribute("tenderId", request.getParameter("tenderId"));
            forwardToJsp(request, response, "newOffer");
        } else {
            forwardToJsp(request, response, "login");
        }
    }
}
