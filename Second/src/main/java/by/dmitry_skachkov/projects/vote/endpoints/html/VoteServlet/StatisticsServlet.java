package by.dmitry_skachkov.projects.vote.endpoints.html.VoteServlet;
import by.dmitry_skachkov.projects.vote.core.dto.Artist;
import by.dmitry_skachkov.projects.vote.core.dto.Genre;
import by.dmitry_skachkov.projects.vote.core.dto.PairData;
import by.dmitry_skachkov.projects.vote.service.VoteService;
import by.dmitry_skachkov.projects.vote.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/statistics")
public class StatisticsServlet extends HttpServlet {

    private static final String ARTIST_PARAM_NAME = "artist";
    private static final String GENRE_PARAM_NAME = "genre";
    private static final String ABOUT_PARAM_NAME = "about";

    private IVoteService voteService = VoteService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<html><body>");

        Map<Artist, Integer> artistStatistics = voteService.getArtistStatistics();
        artistStatistics.forEach((k, v) -> writer.write(k.getName() + " " + v + "</br>"));

        Map<Genre, Integer> genreStatistics = voteService.getGenreStatistics();
        genreStatistics.forEach((k, v) -> writer.write(k.getName() + " " + v + "<br/>"));

        List<PairData<LocalDateTime, String>> aboutsStatistics = voteService.getAbouts();
        aboutsStatistics.forEach((data) -> writer.write(data.getKey() + " " + data.getValue() + "<br/>"));

        writer.write("</body></html>");

    }
}
