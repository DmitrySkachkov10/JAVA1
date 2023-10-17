package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.Airport;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AirportServiceFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;


@WebServlet("/airport")
public class AirportServlet extends HttpServlet {
    private IAirportService airportService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Airport> airportList = airportService.getAirports();

        req.setAttribute("airports", airportList);

        req.getRequestDispatcher("/ui/airport.jsp").forward(req, resp);
    }
}
