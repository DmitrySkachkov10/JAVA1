package org.example.db.factory;


import org.example.db.UserDao;
import org.example.db.api.IUserDao;
import org.example.db.connection.EMFFactory;

public class UserFactory {
    private volatile static UserDao instance;

    private UserFactory() {
    }

    public static IUserDao getInstance() {
        if (instance == null) {
            synchronized (UserFactory.class) {
                if (instance == null) {

                    instance = new UserDao(EMFFactory.getInstance());

                }
            }
        }
        return instance;
    }
}
