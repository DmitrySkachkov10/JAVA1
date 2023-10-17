package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.Airport;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AirportServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/api/airport")
public class AirportJsonServlet extends HttpServlet {
    private static final ObjectMapper mapper = new ObjectMapper();

    private IAirportService airplaneService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airportList = airplaneService.getAirports();

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(mapper.writeValueAsString(airportList));
    }
}
