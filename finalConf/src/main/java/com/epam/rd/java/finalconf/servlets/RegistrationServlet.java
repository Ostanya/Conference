package com.epam.rd.java.finalconf.servlets;

import com.epam.rd.java.finalconf.entity.Role;
import com.epam.rd.java.finalconf.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registrat", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            if(!requestIsValid(request)){
                doGet(request,response);
            }


            final String username = request.getParameter("username");
            final String password = request.getParameter("password");
            final User user = new User(0,username, password, Role.USER);

            // final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");
            // dao.get().add(user);
            System.out.println(user);
            response.sendRedirect("/");
        }catch (ServletException| IOException e){
            e.printStackTrace();
        }
    }


        private boolean requestIsValid(HttpServletRequest req) {
            final String name = req.getParameter("username");
            final String pass = req.getParameter("password");
            return name != null && name.length() > 0 &&
                    pass != null && pass.length() > 0;
        }
}
