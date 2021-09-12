package com.epam.rd.java.finalconf;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HelloServlet extends HttpServlet {

    public void init(ServletConfig servletConfig) {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entry(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entry(req, resp);
    }

    private void entry(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String cPath = request.getContextPath();
        String uPath = request.getRequestURI();
        uPath = uPath.replace(cPath, "").replaceFirst("/", "");
        if(uPath.isEmpty()) {
            uPath = "index";
        }
//        String page = CommandResolver.getCommand(path).execute(request);
//        if (page.contains("redirect:")) {
//            String redirectStr = contextPath + page.replace("redirect:", "");
//            response.sendRedirect(redirectStr);
//        } else {
//            request.getRequestDispatcher(page).forward(request, response);
//        }
    }

    public void destroy() {
    }
}