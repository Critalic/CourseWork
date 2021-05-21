package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.Validators.EmptyValidator;
import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewLotStrategy extends SomeStrat{
    private LotService lotService;
    public NewLotStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToJsp(request, response, "NewLot");
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            String lotName = EmptyValidator.checkIfEmpty(request.getParameter("lotName"), "Lot's name");
            String lotInfo = request.getParameter("lotInfo");
            String price = EmptyValidator.checkIfEmpty(request.getParameter("lotStartPrice"), "Start price");
            lotService.createNewLot(user.getName(), lotName, user.getLogin(), lotInfo, price);
            request.getSession().setAttribute("ownersLots", lotService.getLotsWithOwner(user.getLogin()));
        } catch (DBError dbError) {
            dbError.printStackTrace();
        }

        forwardToJsp(request, response, "MainPage");
    }
}
