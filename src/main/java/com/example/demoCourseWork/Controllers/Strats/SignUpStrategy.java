package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpStrategy extends SomeStrat {
    private UserService userService;

    SignUpStrategy (UserService userService) {
        this.userService = userService;
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
