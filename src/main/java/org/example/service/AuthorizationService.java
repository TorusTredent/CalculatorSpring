package org.example.service;

import org.example.entity.User;
import org.example.memory.UserMemory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationService {
    private final UserMemory memory;

    public AuthorizationService(UserMemory memory) {
        this.memory = memory;
    }

    public boolean isExistUsername(String username) {
        return memory.isExistUsername(username);
    }

    public boolean isSuitPassword(String username, String password) {
        return memory.isSuitPassword(username, password);
    }

    public void registrationUser(User user) {
        memory.addUser(user);
    }

    public User getUser(String username, String password) {
        return memory.getUserByNameAndPassword(username, password);
    }

    public boolean isUserListEmpty() {
        return memory.isUserListEmpty();
    }
}
