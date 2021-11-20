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

    public int getIntValue() {
        while (!scanner.hasNextInt()) {
            writer.write("Incorrect date entered");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getStringValue() {
        while (!scanner.hasNext()) {
            writer.write("Incorrect date entered");
            scanner.next();
        }
        return scanner.next();
    }

    public double getNumber() {
        while (!scanner.hasNextDouble()) {
            writer.write("Incorrect date entered");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String getOperation() {
        String operation;
        do {
            while (!scanner.hasNext()) {
                writer.write("Incorrect date entered");
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
                writer.write("Incorrect date entered");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value != 0 && value != 1);
        return value;
    }
}
