package com.example.demoCourseWork.Controllers.Decorators;


import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetStatusRequestDecorator extends ProcessRequestDecorator {

    LotService lotService;
    public SetStatusRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            forwardToJsp(request, response, "login");
            return;
        }

        try {
            String tenderId = request.getParameter("tenderId");
            lotService.setLotStatus(
                    request.getParameter("tenderId"),
                    user.getLogin(),
                    request.getParameter("status").equals("1")
            );
            response.sendRedirect(request.getContextPath()+"/tenders/tender?tenderId="+tenderId);
        } catch (Exception | DBError e) {
            response.sendRedirect(request.getContextPath()+"/tenders/");
        }
    }
}
