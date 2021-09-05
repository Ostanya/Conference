package com.epam.rd.java.finalconf.servlets.events;

import com.epam.rd.java.finalconf.entity.repository.EventRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/event-list")
public class EventListServlet extends HttpServlet {

    private EventRepository eventRepository;

    @Override
    public void init() {eventRepository = EventRepository.getEventRepository();}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/event-list.jsp");
        request.setAttribute("events", eventRepository.all());
        rd.forward(request, response);
    }
}
