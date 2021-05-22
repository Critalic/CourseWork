package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Exceptions.NotAnOwnerException;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatusStrategy extends SomeStrat {
    LotService lotService;
    public ChangeStatusStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String lotId = (String) request.getSession().getAttribute("lotId");
            Lot currentLot= lotService.getLotById(lotId);
            User user = (User) request.getSession().getAttribute("user");
            lotService.setLotStatus(lotId, user.getLogin(), !currentLot.isActive());
            request.getSession().setAttribute("ownersLots", lotService.getLotsWithOwner(user.getLogin()));
            request.getSession().setAttribute("lots", lotService.getLots());
        } catch (DBError | NoIDException | NotAnOwnerException dbError) {
            dbError.printStackTrace();
        }
        forwardToJsp(request,response, "MainPage");
    }
}
