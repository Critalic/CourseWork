package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MakeOfferStrategy extends SomeStrat {
    LotService lotService;
    public MakeOfferStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            lotService.createNewOffer(
                    request.getParameter("text"),
                    request.getParameter("bid"),
                    (String) request.getSession().getAttribute("lotId"),
                    user.getLogin()
            );
            request.getSession().setAttribute("lots", lotService.getLots());
        } catch (DBError | NoIDException dbError) {
            dbError.printStackTrace();
            return;
        }

        forwardToJsp(request, response, "AllLots");
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToJsp(request, response, "NewOffer");
    }
}
