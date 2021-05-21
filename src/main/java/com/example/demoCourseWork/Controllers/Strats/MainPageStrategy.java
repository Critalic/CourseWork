package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageStrategy extends SomeStrat{
    LotService lotService;
    public MainPageStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            request.getSession().setAttribute("ownersLots", lotService.getLotsWithOwner(user.getLogin()));

        } catch (DBError dbError) {
            dbError.printStackTrace();
        }
        forwardToJsp(request,response, "MainPage");
    }
}
