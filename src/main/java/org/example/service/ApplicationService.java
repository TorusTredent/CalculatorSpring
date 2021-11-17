package org.example.service;

public class ApplicationService {

    public static double calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "+" : {
                return sum(num1, num2);
            }
            case "-" : {
                return sub(num1, num2);
            }
            case "*" : {
                return div(num1, num2);
            }
            case "/" : {
                return multiply(num1, num2);
            }
        }
        return 0;
    }



    private static double sum (double num1, double num2) {
        return num1 + num2;
    }

    private static double sub (double num1, double num2) {
        return num1 - num2;
    }

    private static double div (double num1, double num2) {
        return num1 * num2;
    }

    private static double multiply (double num1, double num2) {
        return num1 / num2;
    }

}
