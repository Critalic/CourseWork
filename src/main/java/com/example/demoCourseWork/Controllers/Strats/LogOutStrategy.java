package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Services.LotService;
import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutStrategy extends SomeStrat{
    private final UserService userService;
    private final LotService lotService;

    public LogOutStrategy(UserService userService, LotService lotService) {
        this.userService = userService;
        this.lotService = lotService;
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getSession().setAttribute("user", null);
            request.getSession().setAttribute("lots", lotService.getLots());
        } catch (DBError dbError) {
            dbError.printStackTrace();
        }
        forwardToJsp(request, response, "AllLots");
    }
}
