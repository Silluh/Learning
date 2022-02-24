package main.com.example007.radek;

public class Calculator {

    double plus(double value, double value2) {

        return value + value2;
    }

    double minus(double value, double value2) {

        return value - value2;
    }

    double multi(double value, double value2) {

        return value * value2;
    }

    double divide(double value, double value2) {

        if (value2 == 0) {
            System.out.println("You can't divide by zero!");
            System.exit(0);
        }
        return value / value2;
    }
}
