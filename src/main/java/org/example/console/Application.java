package org.example.console;

import org.example.entity.User;
import org.example.service.ApplicationService;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final ConsoleReader reader;
    private final ConsoleWriter writer;
    private final ApplicationService appService;
    private final UserService userService;
    private User user;

    public Application(ConsoleReader reader, ConsoleWriter writer, ApplicationService appService,
                       UserService userService, User user) {
        this.reader = reader;
        this.writer = writer;
        this.appService = appService;
        this.userService = userService;
        this.user = user;
    }

    public void run() {
        while (true) {
            writer.write("1) Sing in");
            writer.write("2) Registration");
            writer.write("3) Exit");
            int i = reader.getIntValue();
            if (i == 3) {
                writer.write("Exit...");
                return;
            }
            authorization(i);
        }
    }


    private void authorization(int i) {
        switch (i) {
            case 1: {
                if (userService.isUserListEmpty()) {
                    writer.write("User list is empty");
                } else {
                    writer.write("Input username: ");
                    String username = reader.getStringValue();
                    if (userService.isExistUsername(username)) {
                        writer.write("Input password: ");
                        String password = reader.getStringValue();
                        if (userService.isSuitPassword(username, password)) {
                            user = userService.getUser(username, password);
                            mainMenu();
                        } else {
                            writer.write("Incorrect password entered");
                        }
                    } else {
                        writer.write("Incorrect username entered");
                    }
                }
                return;
            }
            case 2: {
                writer.write("Input username: ");
                String username = reader.getStringValue();
                if (!userService.isExistUsername(username)) {
                    writer.write("Input password: ");
                    String password = reader.getStringValue();
                    userService.registrationUser(username, password);
                    writer.write("User create");
                    return;
                }
                writer.write("Incorrect date entered");
                return;
            }
            default: {
                writer.write("Incorrect number entered");
            }
        }
    }

    private void mainMenu() {
        while (true) {
            writer.write("1) Profile");
            writer.write("2) Calculator");
            writer.write("3) History");
            writer.write("4) Delete history");
            writer.write("5) Logout");
            int i = reader.getIntValue();
            if (i == 5) {
                return;
            }
            personalMenu(i);
        }
    }

    private void personalMenu(int i) {
        switch (i) {
            case 1: {
                profileMenu();
                return;
            }
            case 2: {
                calculator();
                return;
            }
            case 3: {
                appService.showOperationHistory(user.getId());
                return;
            }
            case 4: {
                appService.deleteOperationHistory(user.getId());
                writer.write("History has been deleted");
                return;
            }
            default: {
                writer.write("Incorrect number entered");
            }
        }
    }


    private void profileMenu() {
        while (true) {
            writer.write("1) Show username and password");
            writer.write("2) Change username");
            writer.write("3) Change password");
            writer.write("4) Back");
            int i = reader.getIntValue();
            if (i == 4) {
                return;
            }
            selectedItemProfileMenu(i);
        }
    }

    private void selectedItemProfileMenu(int i) {
        switch (i) {
            case 1: {
                userService.showUserData(user.getId());
                return;
            }
            case 2: {
                writer.write("Input new username: ");
                String newUsername = reader.getStringValue();
                userService.changeUsername(user.getId(), newUsername);
                writer.write("Changes complete");
                return;
            }
            case 3: {
                writer.write("Input new password: ");
                String newPassword = reader.getStringValue();
                userService.changePassword(user.getId(), newPassword);
                writer.write("Changes complete");
                return;
            }
            default: {
                writer.write("Incorrect number entered");
            }
        }
    }


    private void calculator() {
        int exit;
        do {
            writer.write("Input 1 number: ");
            double num1 = reader.getDoubleValue();

            writer.write("Input 2 number: ");
            double num2 = reader.getDoubleValue();

            writer.write("Choose 1 from operations: '+', '-', '*', '/';");
            String operation = reader.getOperation();

            double calcResult = appService.calculate(num1, num2, operation, user.getId());

            writer.write(num1 + " " + operation + " " + num2 + " = " + calcResult);
            writer.write("Input 1 - if u want to continue, 0 - if u want to exit");

            exit = reader.getExitValue();
        } while (exit == 1);
    }
}
