package org.example.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReaderService {
    private final Scanner scanner;

    public ConsoleReaderService(Scanner scanner) {
        this.scanner = scanner;
    }

    public double checkNumber() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Вы ввели значение не того типа");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String checkOperation() {
        String operation;
        do {
            while (!scanner.hasNext()) {
                System.out.println("Вы ввели значение не того типа");
                scanner.next();
            }
            operation = scanner.nextLine();
        } while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));
        return operation;
    }

    public int checkExitValue() {
        int value;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Вы ввели значение не того типа");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value != 0 && value != 1);
        return value;
    }
}
