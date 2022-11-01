package main.com.example009.radek.v3;

import java.io.IOException;

public class ExtendedInitializedCalculatorV3Application {

    public static void main(String[] args) throws IOException {

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
        extendedCalculator.storeResultsIntoFile();
        extendedCalculator.loadResultsFromFile();
    }
}
