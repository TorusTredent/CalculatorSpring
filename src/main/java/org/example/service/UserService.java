package org.example.service;

import org.example.console.ConsoleWriter;
import org.example.entity.User;
import org.example.memory.UserMemory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserMemory memory;
    private final ConsoleWriter writer;

    public UserService(UserMemory memory, ConsoleWriter writer) {
        this.memory = memory;
        this.writer = writer;
    }

    public boolean isExistUsername(String username) {
        return memory.isExistUsername(username);
    }

    public boolean isSuitPassword(String username, String password) {
        return memory.isSuitPassword(username, password);
    }

    public void registrationUser(String username, String password) {
        memory.addUser(new User(username, password));
    }

    public User getUser(String username, String password) {
        return memory.getUserByNameAndPassword(username, password);
    }

    public boolean isUserListEmpty() {
        return memory.isUserListEmpty();
    }

    public void showUserData(double userId) {
        User user = memory.getUserById(userId);
        writer.write("Username - " + user.getUsername());
        writer.write("Password - " + user.getPassword());
    }

    public void changePassword(double userId, String newPassword) {
        memory.changePassword(userId, newPassword);
    }

    public void changeUsername(double userId, String newUsername) {
        memory.changeUsername(userId, newUsername);
    }
}
