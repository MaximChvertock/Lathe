package by.chvertock.lathe.service.user;

import by.chvertock.lathe.dao.user.UserDao;
import by.chvertock.lathe.model.entities.user.Role;
import by.chvertock.lathe.model.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Transactional
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public User getUserByEMail(String username) {
        return userDao.getUserByEMail(username);
    }

    @Transactional
    public List<User> getUsers(Role role) {
        List<User> users = userDao.getUsers();

        List<User> result = new ArrayList<User>();

        for (User user : users) {
            for (Role r : user.getRoles()) {
                if (r.getRole().equals(role.getRole())) {
                    result.add(user);
                    break;
                }
            }
        }

        return result;
    }
}
