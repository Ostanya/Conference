package com.epam.rd.java.finalconf;
import com.epam.rd.java.finalconf.util.CommandDescriptor;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Main extends HttpServlet {

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
        String contextPath = request.getContextPath();
        String path = request.getRequestURI();
        path = path.replace(contextPath, "").replaceFirst("/", "");
        if(path.isEmpty()) {
            path = "index";
        }
       String page = CommandDescriptor.getCommand(path).execute(request);
       if (page.contains("redirect:")) {
            String redirectStr = contextPath + page.replace("redirect:", "");
           response.sendRedirect(redirectStr);
       } else {
           request.getRequestDispatcher(page).forward(request, response);
       }
    }

    public void destroy() {
    }
}