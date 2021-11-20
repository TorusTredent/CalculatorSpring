package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Operation {
    private double id;
    private String num1;
    private String num2;
    private String operation;
    private String result;
    private double userId;

    @Autowired
    public Operation() {
    }

    public Operation(String num1, String num2, String operation, String result, double userId) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
        this.userId = userId;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }
}
