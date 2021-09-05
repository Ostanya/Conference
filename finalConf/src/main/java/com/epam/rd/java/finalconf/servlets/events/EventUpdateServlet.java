package com.epam.rd.java.finalconf.servlets.events;

import com.epam.rd.java.finalconf.entity.Event;
import com.epam.rd.java.finalconf.entity.repository.EventRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/edit-event")
public class EventUpdateServlet extends HttpServlet {

    private EventRepository eventRepository;
    private Event event;

    @Override
    public void init() throws ServletException{
        eventRepository = EventRepository.getEventRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvent = Integer.parseInt(request.getParameter("id"));
        event = eventRepository.read(idEvent);

        if(event == null) {
            response.sendError(404, "Event with ID '" +
                    idEvent + "' not found in Event List!");
        } else {
            request.setAttribute("event", event);
            request.getRequestDispatcher("/WEB-INF/view/edit-event.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        event.setEventName(request.getParameter("title"));
        event.setTopic(request.getParameter("topic"));

        boolean eventStatus = eventRepository.update(event);
        if(eventStatus) {
            response.sendRedirect("/event-list");
        } else {
            request.setAttribute("error", "Event with a given name already exists!");
            request.setAttribute("event", event);
            request.getRequestDispatcher("/WEB-INF/pages/edit-event.jsp").forward(request, response);
        }
    }
}
