package main.com.example009.radek.v1;

class Calculator {

    double result;

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
}
