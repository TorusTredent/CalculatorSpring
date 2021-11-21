package org.example.memory;

import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class OperationMemory {
    private LinkedList<Operation> operationList;

    public OperationMemory(LinkedList<Operation> operationList) {
        this.operationList = operationList;
    }

    public void addOperation(Operation operation) {
        operationList.addLast(operation);
    }

    public ArrayList<Operation> getOperationList(double userId) {
        ArrayList<Operation> userOperationsList = new ArrayList<>();
        for(Operation list : operationList) {
            if (list.getUserId() == userId) {
                userOperationsList.add(list);
            }
        }
        return userOperationsList;
    }

    public void deleteOperationHistory(double userId) {
        LinkedList<Operation> newList = new LinkedList<>();
        for(Operation list : operationList) {
            if (list.getUserId() != userId) {
                newList.add(list);
            }
        }
        operationList = newList;
    }
}
