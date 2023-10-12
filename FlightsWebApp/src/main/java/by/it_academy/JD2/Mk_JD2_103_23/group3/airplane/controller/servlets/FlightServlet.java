package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.db.enums.Filters;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.FlightServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/flight")
public class FlightServlet extends HttpServlet {

    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        String size = req.getParameter("size");

        if (page != null && size != null) {
            List<Flight> flights = flightService.getFlights(Integer.parseInt(page), Integer.parseInt(size));
            req.setAttribute("flights", flights);
        } else {
            List<Flight> flights = flightService.getFlights();
            req.setAttribute("flights", flights);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = req.getParameter("page");
        String size = req.getParameter("size");
        String[] selectedFilters = req.getParameterValues("filters");

        List<Flight> flights = new ArrayList<>();
        List<String> activeFilters = new ArrayList<>();

        for (String string : selectedFilters) {
            activeFilters.add(Filters.valueOf(string).getFilterValue());
        }


        if (page != null && size != null && !activeFilters.isEmpty()) {
            flights = flightService.getFlights(Integer.parseInt(page), Integer.parseInt(size), activeFilters);
        } else if (page != null && size != null) {
            flights = flightService.getFlights(Integer.parseInt(page), Integer.parseInt(size));
        } else {
            flights = flightService.getFlights();
        }


        req.setAttribute("flights", flights);
        req.getRequestDispatcher("/ui/flight.jsp").forward(req, resp);

    }
}
