package main.com.example009.radek.v2;

public class ExtendedCalculatorV2 extends Calculator {

    ExtendedCalculatorV2(double defaultResult) {

        super(defaultResult);
    }

    public boolean isOdd() {

        if (getResult() % 1 != 0) {
            System.out.println("Only whole number can be odd or even");
            return false;
        }
        return getResult() % 2 == 0;
    }

    public void square() {

        setResult(getResult() * getResult());
    }

    public void squareRoot() {

        setResult(Math.sqrt(getResult()));
    }
}
