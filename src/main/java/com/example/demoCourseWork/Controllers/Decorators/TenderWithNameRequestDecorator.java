package com.example.demoCourseWork.Controllers.Decorators;


import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenderWithNameRequestDecorator extends ProcessRequestDecorator {

    private LotService lotService;
    public TenderWithNameRequestDecorator(LotService lotService) {
        this.lotService = lotService;
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String searchString = request.getParameter("search");
            if (searchString != null && !searchString.isEmpty()){
                request.setAttribute("tenders", lotService.getLotsByName(searchString));
                forwardToJsp(request, response, "tendersList");
                return;
            }
            forwardToJsp(request, response, "tenderSearch");
        } catch (DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
    }
}
