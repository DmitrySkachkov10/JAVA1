package by.dmitry_skachkov.projects.vote.service;

import by.dmitry_skachkov.projects.vote.core.dto.Artist;
import by.dmitry_skachkov.projects.vote.core.dto.Genre;
import by.dmitry_skachkov.projects.vote.core.dto.PairData;
import by.dmitry_skachkov.projects.vote.core.dto.Vote;
import by.dmitry_skachkov.projects.vote.core.exeptions.ValidationExeption;
import by.dmitry_skachkov.projects.vote.dao.api.IVoteDao;
import by.dmitry_skachkov.projects.vote.dao.factory.VoteDaoFactory;
import by.dmitry_skachkov.projects.vote.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class VoteService implements IVoteService {


    private static VoteService instance;

    private IVoteDao voteDao = VoteDaoFactory.getInstance();


    private VoteService() {

    }


    @Override
    public Map<Artist, Integer> getArtistStatistics() {
        return this.voteDao.getArtistStatistics();
    }

    @Override
    public Map<Genre, Integer> getGenreStatistics() {
        return this.voteDao.getGenreStatistics();
    }

    @Override
    public List<PairData<LocalDateTime, String>> getAbouts() {
        return this.voteDao.getAbouts();
    }

    @Override
    public void save(Vote vote) {
        if (vote == null) {
            throw new IllegalArgumentException("нет информации о голосе");
        }

        if (vote.getGenres() != null) {
            int size = vote.getGenres().size();
            if (size < 3 || size > 5) {
                throw new ValidationExeption("Выбрано неправильное количесвто жанров");
            }
        } else {
            throw new IllegalArgumentException("нет информации о жанрах");
        }
        voteDao.save(vote);
    }

    public static VoteService getInstance() {
        if (instance == null) {
            return new VoteService();
        } else {
            return instance;
        }
    }
}
