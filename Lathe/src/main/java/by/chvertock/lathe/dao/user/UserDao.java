/*
 * Author: Maksim Chvertock
 * Copyright (c) 2016.
 */

package by.chvertock.lathe.dao.user;


import by.chvertock.lathe.model.entities.user.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(User user);
    User getUser(long id);
    List<User> getUsers();

    User getUserByEMail(String email);
}
