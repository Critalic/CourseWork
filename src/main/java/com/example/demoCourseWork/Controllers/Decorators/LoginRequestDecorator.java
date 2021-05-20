package com.example.demoCourseWork.Controllers.Decorators;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Exceptions.WrongPasswordException;
import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginRequestDecorator extends ProcessRequestDecorator {

    private UserService userService;

    public LoginRequestDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getSession().setAttribute("user",
                    userService.logIn(
                            request.getParameter("email").trim(),
                            request.getParameter("password").trim()
                    )
            );
        } catch (NoIDException | DBError e) {
            request.setAttribute("errorMessage", e.getLocalizedMessage());
            forwardToJsp(request, response,"signup");
            return;
        } catch (WrongPasswordException | IllegalArgumentException e) {
            request.setAttribute("errorMessage", e.getLocalizedMessage());
            forwardToJsp(request, response,"login");
            return;
        } catch (NullPointerException e) {
            request.setAttribute("errorMessage", "Empty fields!");
            forwardToJsp(request, response,"login");
            return;
        } catch (NoSuchAlgorithmException e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath()+"/tenders/");
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        forwardToJsp(request, response,"login");
    }
}
