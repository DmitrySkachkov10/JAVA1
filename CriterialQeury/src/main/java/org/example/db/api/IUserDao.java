package org.example.db.api;


import org.example.entity.User;

public interface IUserDao {
    void createUser(User user);

    void checkUser(User user);
     void printAllUserTabs();
}
