package main.com.example098.radek;

public class FibonacciSequenceEntryPoint {

    public static void main(String[] args) {

        System.out.println(getNumberOfFibonacciEntryPoint(7));
    }

    static int getNumberOfFibonacciEntryPoint(int entryPoint) {

        int previousNumber = 0;
        int currentNumber = 1;
        for (int i = 0; i < entryPoint; i++) {
            if (i > 1) {
                currentNumber = currentNumber + previousNumber;
                previousNumber = currentNumber;
            }
        }
        return currentNumber;
    }
}
