package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Services.LotService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewLotStrategy extends SomeStrat {
    private LotService lotService;
    public ViewLotStrategy (LotService lotService) {
        this.lotService = lotService;
    }
    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("lot",lotService.getLotById(request.getParameter("lotID")));
            request.getSession().setAttribute("lotId", request.getParameter("lotID"));
        } catch (DBError | NoIDException dbError) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
        forwardToJsp(request, response, "LotDisplayer");
    }
}
