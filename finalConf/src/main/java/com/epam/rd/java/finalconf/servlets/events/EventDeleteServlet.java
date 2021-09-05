package com.epam.rd.java.finalconf.servlets.events;

import com.epam.rd.java.finalconf.entity.repository.EventRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete-event")
public class EventDeleteServlet extends HttpServlet {

    private EventRepository eventRepository;
    public static final int SC_NOT_FOUND = 404;

    @Override
    public void init() {eventRepository = EventRepository.getEventRepository();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if(eventRepository.delete(id)) {
            response.sendRedirect("/event-list");
        }else{
            response.sendError(SC_NOT_FOUND, "Event with ID'" +
                    id + "' not found in Event list!");
        }
    }
}
