package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirplaneService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.entity.AirCraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AirplaneServiceFactory;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/plane")
public class AirplaneServlet extends HttpServlet {
    private IAirplaneService airplaneService = AirplaneServiceFactory.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<AirCraft> aircrafts = airplaneService.getAirCrafts(); // Получаем список данных

        req.setAttribute("aircrafts", aircrafts);
        req.getRequestDispatcher("/ui/plane.jsp").forward(req, resp);
    }
}
