package main.com.example009.radek.v3;

import java.io.IOException;

public class ExtendedInitializedCalculatorV3Application {

    public static void main(String[] args) throws IOException {

        ExtendedCalculatorV3 extendedCalculator = new ExtendedCalculatorV3(25);
        FileService fileService = new FileService();
        fileService.loadPreviousResultFile();
        extendedCalculator.plus(5);
        extendedCalculator.StoreResult();
        extendedCalculator.minus(10);
        extendedCalculator.square();
        extendedCalculator.StoreResult();
        extendedCalculator.multiply(10);
        extendedCalculator.StoreResult();
        extendedCalculator.squareRoot();
        extendedCalculator.StoreResult();
        extendedCalculator.storeResultsIntoFile();
        extendedCalculator.loadResultsFromFile(fileService.getCheckedUserInput());
    }
}
