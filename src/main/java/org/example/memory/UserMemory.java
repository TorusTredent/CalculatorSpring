package org.example.memory;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMemory {
    private final ArrayList<User> userList;

    public UserMemory(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean isUserListEmpty() {
        return userList.isEmpty();
    }

    public boolean isExistUsername(String username) {
        for (User list : userList) {
            if (username.equals(list.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuitPassword(String username, String password) {
        for (User list : userList) {
            if (username.equals(list.getUsername())) {
                if (password.equals(list.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByNameAndPassword(String username, String password) {
        for (User list : userList) {
            if (username.equals(list.getUsername())) {
                if (password.equals(list.getPassword())) {
                    return list;
                }
            }
        }
        return null;
    }

    public User getUserById(double userId) {
        for (User list : userList) {
            if (list.getId() == userId) {
                return list;
            }
        }
        return null;
    }
}
