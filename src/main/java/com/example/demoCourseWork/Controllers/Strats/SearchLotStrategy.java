package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.models.Lot;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchLotStrategy extends SomeStrat{
    LotService lotService;
    public SearchLotStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToJsp(request, response, "SearchLot");
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String input = request.getParameter("input");
            ArrayList<Lot> answer = new ArrayList<>();
            List<Lot> lots =  lotService.getLots();
            for(Lot l : lots) {
                if(l.getInfo().contains(input) || l.getName().contains(input)) answer.add(l);
            }
            request.setAttribute("lotsFound", answer);
        } catch (DBError dbError) {
            dbError.printStackTrace();
        }
        forwardToJsp(request, response, "SearchLot");
    }
}
