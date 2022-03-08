package main.com.example008.radek;

public class ExtendedCalculatorV1 extends Calculator {

    public boolean isThisNumberOdd(double value) {

        return value % 2 == 0 ? true : false;

    }

    public double square(double value) {

        return value * value;
    }

    public double squareRoot(double value) {

        return Math.sqrt(value);

    }
}
