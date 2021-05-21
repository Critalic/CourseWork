package com.example.demoCourseWork.Controllers.Strats;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Exceptions.WrongPasswordException;
import com.example.demoCourseWork.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LogInStrategy extends SomeStrat {
    private final UserService userService;

    public LogInStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void dewPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getSession().setAttribute("user",
                    userService.logIn(
                            request.getParameter("email").trim(),
                            request.getParameter("password").trim()
                    )
            );
        } catch (NoIDException e) {
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
        } catch (NoSuchAlgorithmException | DBError e) {
            request.getRequestDispatcher("/WEB-INF/undefinedError.html").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath()+"/lots/");
    }

    @Override
    public void dewGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        forwardToJsp(request, response,"LogIn");
    }
}
