package main.com.example009.radek.v1;

public class ExtendedCalculatorV1 extends Calculator {

    ExtendedCalculatorV1(double defaultResult) {
        super(defaultResult);
    }

    public boolean isThisNumberOdd() {

        return super.result % 2 == 0 ? true : false;
    }

    public void square() {

        super.result = result * result;
    }

    public void squareRoot() {

        super.result = Math.sqrt(super.result);
    }
}
