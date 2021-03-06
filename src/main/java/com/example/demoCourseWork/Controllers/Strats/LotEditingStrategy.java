package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LotEditingStrategy extends SomeStrat{
    LotService lotService;
    public LotEditingStrategy(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lotId = request.getParameter("lotID");
        request.getSession().setAttribute("lotId", lotId);
        try {
            request.setAttribute("lot", lotService.getLotById(lotId));
        } catch (DBError | NoIDException dbError) {
            dbError.printStackTrace();
        }
        forwardToJsp(request, response, "LotEditor");
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.dewPost(request, response);
    }
}
