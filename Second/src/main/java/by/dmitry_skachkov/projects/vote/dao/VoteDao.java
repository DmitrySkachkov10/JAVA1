package by.dmitry_skachkov.projects.vote.dao;

import by.dmitry_skachkov.projects.vote.core.dto.Artist;
import by.dmitry_skachkov.projects.vote.core.dto.Genre;
import by.dmitry_skachkov.projects.vote.core.dto.PairData;
import by.dmitry_skachkov.projects.vote.core.dto.Vote;
import by.dmitry_skachkov.projects.vote.dao.api.IVoteDao;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VoteDao implements IVoteDao {


    private final Map<Artist, Integer> artists = new ConcurrentHashMap<>();

    private final Map<Genre, Integer> genres = new ConcurrentHashMap<>();

    private final List<PairData<LocalDateTime, String>> about = new ArrayList<>();

    @Override
    public void save(Vote vote) {
        this.artists.compute(vote.getArtist(), (k, v) -> v != null ? ++v : 1);
        vote.getGenres().forEach(g -> this.genres.compute(g, (k, v) -> v != null ? ++v : 1));
        synchronized (about) {
            this.about.add(new PairData<>(LocalDateTime.now(), vote.getAbout()));
        }
    }

    @Override
    public Map<Artist, Integer> getArtistStatistics() {
        return this.artists;
    }

    @Override
    public Map<Genre, Integer> getGenreStatistics() {
        return this.genres;
    }

    @Override
    public List<PairData<LocalDateTime, String>> getAbouts() {
        return this.about;
    }


}
