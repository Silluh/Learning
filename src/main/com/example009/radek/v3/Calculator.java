package main.com.example009.radek.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Calculator {

    private double result;

    private final List<Double> list = new ArrayList<>();

    private final FileService fileService = new FileService();

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

    void loadResultsFromFile(String name) throws IOException {

        fileService.loadResultsFromFile(name);
    }

    void storeResultsIntoFile() {

        fileService.storeResultsIntoFile(list);
    }

    void storeResult() {

        list.add(this.result);
    }
}
