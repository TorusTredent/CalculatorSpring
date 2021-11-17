package org.example;

import org.example.service.ApplicationService;
import org.example.service.ConsoleReaderService;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final ConsoleReaderService console;

    public Application(ConsoleReaderService console) {
        this.console = console;
    }

    public void run() {
        int exit;
        do {
            System.out.println("Введите 1 число: ");
            double num1 = console.checkNumber();
            System.out.println("Введите 2 число: ");
            double num2 = console.checkNumber();
            System.out.println("Введите 1 из операций: '+', '-', '*', '/';");
            String operation = console.checkOperation();
            double calculate = ApplicationService.calculate(num1, num2, operation);
            System.out.println(num1 + " " + operation + " " + num2 + " = " + calculate);
            System.out.println("Введите 1-если хотите продолжить, 0-если хотите выйти: ");
            exit = console.checkExitValue();
        } while(exit == 1);
    }
}
