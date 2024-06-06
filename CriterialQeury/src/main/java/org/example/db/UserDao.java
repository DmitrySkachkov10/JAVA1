package org.example.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.example.db.api.IUserDao;
import org.example.entity.Tabs;
import org.example.entity.User;

import java.util.List;
import java.util.Set;

public class UserDao implements IUserDao {

    private final EntityManagerFactory emf;

    public UserDao(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public void createUser(User user) {

    }

    @Override
    public void checkUser(User user) {

    }

    public void printAllUserTabs() {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<User> userQuery = cb.createQuery(User.class);
            Root<User> userRoot = userQuery.from(User.class);
            userRoot.fetch("tabs", JoinType.LEFT);

            userQuery.select(userRoot);
            userQuery.distinct(true);

            List<User> users = em.createQuery(userQuery).getResultList();

            for (User user : users) {
                System.out.println("User: " + user);
                Set<Tabs> tabs = user.getTabs();
                for (Tabs tab : tabs) {
                    System.out.println("  Tab: " + tab);
                }
            }
        } finally {
            em.close();
        }
    }
}
