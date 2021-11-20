package org.example.console;

import org.example.entity.Operation;
import org.example.entity.User;
import org.example.memory.OperationMemory;
import org.example.service.ApplicationService;
import org.example.service.AuthorizationService;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final ConsoleReader reader;
    private final ConsoleWriter writer;
    private final ApplicationService appService;
    private final AuthorizationService authorization;
    private final OperationMemory operationMemory;
    private User user;
    private int counter = 0;

    public Application(ConsoleReader reader, ConsoleWriter writer, ApplicationService appService, AuthorizationService authorization, OperationMemory operationMemory, User user) {
        this.reader = reader;
        this.writer = writer;
        this.appService = appService;
        this.authorization = authorization;
        this.operationMemory = operationMemory;
        this.user = user;
    }

    public void run() {
        writer.write("1) Sing in");
        writer.write("2) Registration");
        int chooser = reader.getIntValue();
        authMenu(chooser);
    }


    private void authMenu(int chooser) {
        switch(chooser) {
            case 1: {
                if (authorization.isUserListEmpty()) {
                    writer.write("User list is empty");
                    run();
                } else {
                    writer.write("Input username: ");
                    String username = reader.getStringValue();
                    if (authorization.isExistUsername(username)) {
                        writer.write("Input password: ");
                        String password = reader.getStringValue();
                        if (authorization.isSuitPassword(username, password)) {
                            user = authorization.getUser(username, password);
                            mainMenu();
                        }
                    }
                    writer.write("Incorrect username or password entered");
                    run();
                }
            }
            case 2: {
                writer.write("Input username: ");
                String username = reader.getStringValue();
                if (!authorization.isExistUsername(username)) {
                    writer.write("Input password: ");
                    String password = reader.getStringValue();

                    user.setId(counter);
                    counter++;
                    user.setUsername(username);
                    user.setPassword(password);

                    authorization.registrationUser(user);
                    writer.write("User create");
                    run();
                }
                writer.write("Incorrect date entered");
                run();
            }
            default: {
                writer.write("Incorrect number entered");
                run();
            }
        }
    }

    private void mainMenu() {
        writer.write("1) Calculator");
        writer.write("2) History");
        writer.write("3) Delete history");
        writer.write("4) Exit");
//        writer.write("1) Profile");
        int chooser = reader.getIntValue();
        personalMenu(chooser);
    }

    private void personalMenu(int chooser) {
        switch(chooser) {
//            case 1: {
//                profileMenu();
//            }
            case 1: {
                calculator();
            }
            case 2: {
                appService.showOperationHistory(user.getId());
                mainMenu();
            }
            case 3: {
                appService.deleteOperationHistory(user.getId());
                writer.write("History has been deleted");
                mainMenu();
            }
            case 4: {
                writer.write("Exit...");
                run();
            }
            default: {
                writer.write("Incorrect number entered");
                mainMenu();
            }
        }
    }

//    private void profileMenu() {
//        writer.write("1) Show username and password");
//        writer.write("2) Change username");
//        writer.write("3) Change password");
//        writer.write("4) Back");
//        int chooser = reader.getIntValue();
//        selectedItemProfileMenu(chooser);
//    }
//
//    private void selectedItemProfileMenu(int chooser) {
//        switch (chooser) {
//            case 1: {
//                appService.showUserData(user.getId());
//                profileMenu();
//            }
//            case 2: {
//                writer.write("Input new password: ");
//                String newPassword = reader.getStringValue();
//                appService.
////                changePassword
//            }
//            case 3: {
////                changeName
//            }
//            case 4: {
////                back
//            }
//            default: {
//
//            }
//        }
//    }

    private void calculator() {
        int exit;
        do {
            writer.write("Input 1 number: ");
            double num1 = reader.getNumber();

            writer.write("Input 2 number: ");
            double num2 = reader.getNumber();

            writer.write("Choose 1 from operations: '+', '-', '*', '/';");
            String operation = reader.getOperation();

            double calcResult = appService.calculate(num1, num2, operation);

            Operation operationResult = new Operation(String.valueOf(num1), String.valueOf(num2), operation,
                    String.valueOf(calcResult), user.getId());

            operationMemory.addOperation(operationResult);

            writer.write(num1 + " " + operation + " " + num2 + " = " + calcResult);
            writer.write("Input 1 - if u want to continue, 0 - if u want to exit");

            exit = reader.getExitValue();
        } while(exit == 1);
        mainMenu();
    }
}
