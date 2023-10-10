package by.dmitry_skachkov.projects.vote.dao.api;

import by.dmitry_skachkov.projects.vote.core.dto.Artist;
import by.dmitry_skachkov.projects.vote.core.dto.Genre;
import by.dmitry_skachkov.projects.vote.core.dto.PairData;
import by.dmitry_skachkov.projects.vote.core.dto.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IVoteDao {
    void save(Vote vote);
    Map<Artist, Integer> getArtistStatistics();

    Map<Genre, Integer> getGenreStatistics();

    List<PairData<LocalDateTime, String>> getAbouts();
}
