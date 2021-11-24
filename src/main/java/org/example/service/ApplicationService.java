package org.example.service;

import org.example.console.ConsoleWriter;
import org.example.entity.Operation;
import org.example.memory.OperationMemory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApplicationService {
    private final OperationMemory operationMemory;
    private final ConsoleWriter writer;

    public ApplicationService(OperationMemory operationMemory, ConsoleWriter writer) {
        this.operationMemory = operationMemory;
        this.writer = writer;
    }

    public double calculate(double num1, double num2, String operation, long userId) {
        double result = 0;
        switch (operation) {
            case "+" : {
                result = CalculateService.sum(num1, num2);
                break;
            }
            case "-" : {
                result = CalculateService.sub(num1, num2);
                break;
            }
            case "*" : {
                result = CalculateService.div(num1, num2);
                break;
            }
            case "/" : {
                result = CalculateService.multiply(num1, num2);
                break;
            }
        }
        operationMemory.addOperation(new Operation(String.valueOf(num1), String.valueOf(num2), operation,
                String.valueOf(result), userId));
        return result;
    }

    public void showOperationHistory(double userId) {
        ArrayList<Operation> operationList = operationMemory.getOperationList(userId);
        for (int i = 0; i < operationList.size(); i++) {
            writer.write((i + 1) + ") " + operationList.get(i).getNum1() + operationList.get(i).getOperation() +
                    operationList.get(i).getNum2() + " = " + operationList.get(i).getResult());
        }
    }

    public void deleteOperationHistory(double userId) {
        operationMemory.deleteOperationHistory(userId);
    }
}
