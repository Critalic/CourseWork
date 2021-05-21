package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowLotsStrategy extends SomeStrat{
    LotService lotService;
    public ShowLotsStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    private void lotsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DBError {
        request.setAttribute("lots", lotService.getLots());
        forwardToJsp(request, response, "AllLots");
    }


    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                lotsList(request, response);
            } catch (DBError e) {
                request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
                return;
            }
    }
}
