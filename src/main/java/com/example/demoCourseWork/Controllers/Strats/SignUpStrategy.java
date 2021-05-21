package com.example.demoCourseWork.Controllers.Strats;

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

public class SignUpStrategy extends SomeStrat {
    private UserService userService;

    public SignUpStrategy (UserService userService) {
        this.userService = userService;
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                userService.signUp(
                        request.getParameter("email"),
                        request.getParameter("name"),
                        request.getParameter("password1"),
                        request.getParameter("password2")
                );
            }  catch (WrongPasswordException | NullPointerException | IllegalArgumentException | AlreadyExistsError | InvalidEmailException e) {
                request.setAttribute("errorMessage", e.getLocalizedMessage());
                forwardToJsp(request, response, "SignUp");
                return;
            } catch (NoSuchAlgorithmException | DBError e) {
                request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
                return;
            }
            forwardToJsp(request, response,"LogIn");
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToJsp(request, response, "SignUp");
    }
}
