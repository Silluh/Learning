package main.com.example009.radek.v1;

public class ExtendedInitializedCalculatorApplication {

    public static void main(String[] args) {

        ExtendedCalculatorV1 extendedCalculator = new ExtendedCalculatorV1(25);
        extendedCalculator.plus(0);
        extendedCalculator.square();
        extendedCalculator.squareRoot();
        System.out.println(extendedCalculator.getResult());
    }
}
