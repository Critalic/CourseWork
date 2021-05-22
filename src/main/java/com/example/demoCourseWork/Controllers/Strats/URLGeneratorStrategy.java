package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Services.LotService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class URLGeneratorStrategy extends SomeStrat{
    LotService lotService;
    public URLGeneratorStrategy(LotService lotService) {
        this.lotService = lotService;
    }
    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url =  lotService.generateURL();
        request.getSession().setAttribute("url", url);
        forwardToJsp(request, response, "LotDisplayer");
    }
}
