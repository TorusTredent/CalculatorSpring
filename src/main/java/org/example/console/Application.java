package org.example.console;

import org.example.service.ApplicationService;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final ConsoleReader reader;
    private final ConsoleWriter writer;
    private final ApplicationService appService;

    public Application(ConsoleReader reader, ConsoleWriter writer, ApplicationService appService) {
        this.reader = reader;
        this.writer = writer;
        this.appService = appService;
    }

    public void run() {
        int exit;
        do {
            writer.write("Введите 1 число: ");
            double num1 = reader.getNumber();
            writer.write("Введите 2 число: ");
            double num2 = reader.getNumber();
            writer.write("Введите 1 из операций: '+', '-', '*', '/';");
            String operation = reader.getOperation();
            double calcResult = appService.calculate(num1, num2, operation);
            writer.write(num1 + " " + operation + " " + num2 + " = " + calcResult);
            writer.write("Введите 1-если хотите продолжить, 0-если хотите выйти: ");
            exit = reader.getExitValue();
        } while(exit == 1);
    }
}
