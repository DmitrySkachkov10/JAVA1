package by.dmitry_skachkov.projects.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");

        PrintWriter writer = resp.getWriter();


        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        HttpSession httpSession = req.getSession();
        if (firstName == null || lastName == null){
            if(!httpSession.isNew()) {
                firstName = (String) httpSession.getAttribute("firstName");
                lastName = (String) httpSession.getAttribute("lastName");
                writer.write(firstName + " " + lastName);
            } else {
                writer.write("error");
            }
        } else {
            writer.write(firstName + " " + lastName);
            httpSession.setAttribute("firstName", firstName);
            httpSession.setAttribute("lastName", lastName);
        }
    }
}
