package main.com.example009.radek.v2;

public class ExtendedInitializedCalculatorV2Application {

    public static void main(String[] args) {

        ExtendedCalculatorV2 extendedCalculator = new ExtendedCalculatorV2(25);
        extendedCalculator.plus(5);
        extendedCalculator.minus(10);
        extendedCalculator.square();
        extendedCalculator.storeResult();
        System.out.println(extendedCalculator.getStoredResult());
        extendedCalculator.multiply(10);
        extendedCalculator.squareRoot();
        System.out.println(extendedCalculator.getStoredResult());
        System.out.println(extendedCalculator.getResult());
    }
}
