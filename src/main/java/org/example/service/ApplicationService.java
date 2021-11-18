package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class ApplicationService {

    public double calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "+" : {
                return CalculateService.sum(num1, num2);
            }
            case "-" : {
                return CalculateService.sub(num1, num2);
            }
            case "*" : {
                return CalculateService.div(num1, num2);
            }
            case "/" : {
                return CalculateService.multiply(num1, num2);
            }
        }
        return 0;
    }
}
