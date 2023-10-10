package by.dmitry_skachkov.projects.vote.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet("/hello_with_name")
public class HelloWithNameServlet extends HttpServlet {
    private HashMap<String, Integer> artistPopularity = new HashMap<>();
    private HashMap<String, Integer> genrePopularity = new HashMap<>();
    private LinkedList<String> userInfo = new LinkedList<>();

    @Override
    public void init() throws ServletException {

        artistPopularity.put("СОЮЗ", 0);
        artistPopularity.put("Apple Picker", 0);
        artistPopularity.put("Blesk Baty", 0);
        artistPopularity.put("Borisovsky Trakt", 0);


        genrePopularity.put("Rock", 0);
        genrePopularity.put("Pop", 0);
        genrePopularity.put("Rap", 0);
        genrePopularity.put("Indie", 0);
        genrePopularity.put("Shoegaze", 0);
        genrePopularity.put("Jazz", 0);
        genrePopularity.put("Blues", 0);
        genrePopularity.put("RnB", 0);
        genrePopularity.put("Techno", 0);
        genrePopularity.put("Other", 0);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        var writer = resp.getWriter();

        String[] genres = req.getParameterValues("genre");


        if (!isGenresInput(genres.length)) {
            writer.write("<html><body>" + "<p><a href=/Second-1.1.2-SNAPSHOT/firstpost.html>Выберите от 2 до 6 жанров</a></p>" + "</body></html>");
        } else {

            String[] artists = req.getParameterValues("bestArtist");
            userInfo.add(req.getParameter("userInfo"));

            updatePopularity(artists, artistPopularity);
            updatePopularity(genres, genrePopularity);

            writer.write("<html><body><p><b>User's info:</b></p> ");

            userInfo.forEach( (input) -> writer.write("userInfo = " + input + "<br>") );

            writer.write("<br>");
            artistPopularity = sortByValue(artistPopularity);
            genrePopularity = sortByValue(genrePopularity);

            writer.write("<p><b>Top Artist:</b><p>");
            artistPopularity.forEach((key, value) -> writer.write(key + " " + value + "<br>"));

            writer.write("<p><b>Top Genres:</b></p>");
            genrePopularity.forEach((key, value) -> writer.write(key + " " + value + "<br>"));


            writer.write("<p><a href=/Second-1.1.2-SNAPSHOT/firstpost.html> Вернуться к опросу </a></p>");

            writer.write("</body></html>");

        }


    }

    private void updatePopularity(String[] types, HashMap<String, Integer> map) {
        for (String type : types) {
            map.computeIfPresent(type, (key, value) -> value + 1);
        }
    }

    private boolean isGenresInput(int input) {
        return input > 2 && input < 6;
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {

        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMap;
    }
}




