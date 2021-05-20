package com.example.demoCourseWork.Controllers.Decorators;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LotListRequestDecorator extends ProcessRequestDecorator {

    private LotService lotService;
    public LotListRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    private void lotsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DBError {
        request.setAttribute("tenders", lotService.getLots());
        forwardToJsp(request, response, "tendersList");
    }

    private void ownerLotList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DBError {
        User owner = (User) request.getSession().getAttribute("user");
        if (owner != null) {
            request.setAttribute("tenders", lotService.getLotsWithOwner(owner.getLogin()));
            forwardToJsp(request, response, "tendersList");
        } else {
            forwardToJsp(request, response, "login");
        }
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if ("/myTenders".equals(request.getPathInfo())) {
                ownerLotList(request, response);
            } else {
                lotsList(request, response);
            }
        } catch (DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
    }
}
