package main.com.example008.radek;

public class ExtendedCalculatorV1 extends Calculator {

    public boolean isOdd(double value) {

        if (value % 1 != 0) {
            System.out.println("Only whole number can be odd or even");
            return false;
        }
        return value % 2 == 0;
    }

    public double square(double value) {

        return value * value;
    }

    public double squareRoot(double value) {

        return Math.sqrt(value);
    }
}
