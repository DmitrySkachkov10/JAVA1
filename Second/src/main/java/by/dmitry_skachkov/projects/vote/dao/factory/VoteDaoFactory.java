package by.dmitry_skachkov.projects.vote.dao.factory;
import by.dmitry_skachkov.projects.vote.dao.VoteDao;
public class VoteDaoFactory {
    private volatile static VoteDao instance = new VoteDao();
    private VoteDaoFactory() {

    }
    public static VoteDao getInstance() {
        if (instance == null) {
            synchronized (VoteDaoFactory.class) {
                if (instance == null) {
                    instance = new VoteDao();
                }
            }
        }
        return instance;
    }
}
