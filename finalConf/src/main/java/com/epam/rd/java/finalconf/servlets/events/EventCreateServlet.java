package com.epam.rd.java.finalconf.servlets.events;

import com.epam.rd.java.finalconf.entity.Event;
import com.epam.rd.java.finalconf.entity.repository.EventRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/create-event")
public class EventCreateServlet extends HttpServlet {
    EventRepository eventRepository;

    @Override
    public void init() {
        eventRepository = EventRepository.getEventRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/view/create-event.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nName = request.getParameter("nname");
        String tName = request.getParameter("tname");
        eventRepository.create(new Event(nName, tName));
        doGet(request, response);
    }
}
