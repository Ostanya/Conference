package com.epam.rd.java.finalconf.servlets.events;

import com.epam.rd.java.finalconf.entity.Event;
import com.epam.rd.java.finalconf.entity.repository.EventRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/read-event")
public class EventReadServlet extends HttpServlet {

    private EventRepository eventRepository;
    public static final int SC_NOT_FOUND = 404;

    @Override
    public void init() {
        eventRepository = EventRepository.getEventRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Event event = eventRepository.read(id);
        if(event != null) {
            request.setAttribute("event", event);
            request.getRequestDispatcher("/WEB-INF/view/read-event.jsp").forward(request,response);
        }else{
            response.sendError(SC_NOT_FOUND, "Event with Id '" +
                    id + "' not found in Event List!");
        }
    }
}
