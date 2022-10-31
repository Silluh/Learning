package main.com.example009.radek.v4;

import java.io.IOException;

public class ExtendedInitializedCalculatorV4Application {

    public static void main(String[] args) throws IOException {

        ExtendedCalculatorV4 extendedCalculator = new ExtendedCalculatorV4(25);
        extendedCalculator.plus(5);
        extendedCalculator.setStoreResult();
        extendedCalculator.minus(10);
        extendedCalculator.square();
        extendedCalculator.setStoreResult();
        extendedCalculator.multiply(10);
        extendedCalculator.setStoreResult();
        extendedCalculator.squareRoot();
        extendedCalculator.setStoreResult();
        extendedCalculator.storeResults();
        extendedCalculator.getStoredResults();
    }
}
