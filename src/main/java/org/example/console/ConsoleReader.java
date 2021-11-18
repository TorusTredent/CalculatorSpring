package org.example.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    private final Scanner scanner;
    private final ConsoleWriter writer;

    public ConsoleReader(Scanner scanner, ConsoleWriter writer) {
        this.scanner = scanner;
        this.writer = writer;
    }

    public double getNumber() {
        while (!scanner.hasNextDouble()) {
            writer.write("Вы ввели значение не того типа");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String getOperation() {
        String operation;
        do {
            while (!scanner.hasNext()) {
                writer.write("Вы ввели значение не того типа");
                scanner.next();
            }
            operation = scanner.nextLine();
        } while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));
        return operation;
    }

    public int getExitValue() {
        int value;
        do {
            while (!scanner.hasNextDouble()) {
                writer.write("Вы ввели значение не того типа");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value != 0 && value != 1);
        return value;
    }
}
