package main.com.example009.radek.v1;

public class ExtendedCalculatorV1 extends Calculator {

    ExtendedCalculatorV1(double defaultResult) {
        super(defaultResult);
    }

    public boolean isOdd() {

        if (super.result % 1 != 0) {
            System.out.println("Only whole number can be odd or even");
            return false;
        }
        return super.result % 2 == 0;
    }

    public void square() {

        super.result = result * result;
    }

    public void squareRoot() {

        super.result = Math.sqrt(super.result);
    }
}
