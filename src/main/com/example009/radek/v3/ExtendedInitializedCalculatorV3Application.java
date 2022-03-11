package main.com.example009.radek.v3;

public class ExtendedInitializedCalculatorV3Application {

    public static void main(String[] args) {

        ExtendedCalculatorV3 extendedCalculator = new ExtendedCalculatorV3(25);
        extendedCalculator.plus(5);
        extendedCalculator.setStoreResult();
        extendedCalculator.minus(10);
        extendedCalculator.square();
        extendedCalculator.setStoreResult();
        extendedCalculator.multiply(10);
        extendedCalculator.setStoreResult();
        extendedCalculator.squareRoot();
        extendedCalculator.setStoreResult();
        System.out.println(extendedCalculator.getStoredResults());
        System.out.println(extendedCalculator.getResult());
    }
}
