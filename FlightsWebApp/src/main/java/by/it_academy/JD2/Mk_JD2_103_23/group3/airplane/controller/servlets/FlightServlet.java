package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.Flight;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.FlightServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

@WebServlet(urlPatterns = "/flight")
public class FlightServlet extends HttpServlet {

    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flight> flights = flightService.getFlights();


        // Передаем управление JSP-файлу для отображения данных
        req.getRequestDispatcher("/ui/flight.jsp").forward(req, resp);


    }
}
