package com.sophia.movierentalapi.service;

import com.sophia.movierentalapi.exceptions.UserNotFoundException;
import com.sophia.movierentalapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("sophia", "1234", "user"));
        users.add(new User("wisdom", "1234", "user"));
        users.add(new User("admin", "1234", "admin"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UserNotFoundException();
    }


    public User updateUser(String username, User user) {
        for (User theUser : users) {
            if (theUser.getUsername().equals(username)){
                theUser.setUsername(user.getUsername());
                theUser.setPassword(user.getPassword());
                return theUser;
            }
        }
        throw new UserNotFoundException();
    }

    public void deleteUser(String username) {
        for (User theUser : users) {
            if (theUser.getUsername().equals(username)){
                users.remove(theUser);
                return;
            }
        }
        throw new UserNotFoundException();
    }
}
