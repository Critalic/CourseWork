package com.example.demoCourseWork.Controllers.Decorators;

import com.example.demoCourseWork.Exceptions.AlreadyExistsError;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.InvalidEmailException;
import com.example.demoCourseWork.Exceptions.WrongPasswordException;
import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SignUpRequestDecorator extends ProcessRequestDecorator {

    private UserService userService;
    public SignUpRequestDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            userService.signUp(
                    request.getParameter("email"),
                    request.getParameter("name"),
                    request.getParameter("password"),
                    request.getParameter("password2")
            );
        }  catch (WrongPasswordException | NullPointerException | IllegalArgumentException | InvalidEmailException e) {
            request.setAttribute("errorMessage", e.getLocalizedMessage());
            forwardToJsp(request, response, "signup");
            return;
        } catch (NoSuchAlgorithmException | DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }
        forwardToJsp(request, response,"login");
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToJsp(request, response, "signup");
    }
}
