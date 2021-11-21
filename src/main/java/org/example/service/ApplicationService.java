package org.example.service;

import org.example.console.ConsoleWriter;
import org.example.entity.Operation;
import org.example.entity.User;
import org.example.memory.OperationMemory;
import org.example.memory.UserMemory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApplicationService {
    private final OperationMemory operationMemory;
    private final UserMemory memory;
    private final ConsoleWriter writer;

    public ApplicationService(OperationMemory operationMemory, UserMemory memory, ConsoleWriter writer) {
        this.operationMemory = operationMemory;
        this.memory = memory;
        this.writer = writer;
    }

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
