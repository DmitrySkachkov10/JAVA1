package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AirCraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirplaneService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AirplaneServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/api/plane")
public class AirplaneJsonServlet extends HttpServlet {
    private static final ObjectMapper mapper = new ObjectMapper();

    private IAirplaneService airplaneService = AirplaneServiceFactory.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AirCraft> aircrafts = airplaneService.getAirCrafts(); // Получаем список данных

        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(mapper.writeValueAsString(aircrafts));
    }
}

