package main.com.example009.radek.v2;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    private double result;
    private List<Double> list = new ArrayList<>();

    Calculator(double defaultResult) {

        this.result = defaultResult;
    }

    void plus(double value) {

        this.result = result + value;
    }

    void minus(double value) {

        this.result = result - value;
    }

    void multiply(double value) {

        this.result = result * value;
    }

    void divide(double value) {

        if (value == 0) {
            System.out.println("You can't divide by zero!");
            System.exit(0);
        }
        this.result = result / value;
    }

    double getResult() {

        return this.result;
    }

    void setResult(double input) {

        this.result = input;
    }

    List<Double> getStoredResults() {

        return list;
    }

    void storeResults() {

        list.add(this.result);
    }
}
