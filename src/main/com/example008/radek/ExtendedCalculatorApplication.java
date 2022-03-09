package main.com.example008.radek;

public class ExtendedCalculatorApplication {

    public static void main(String[] args) {

        ExtendedCalculatorV1 calculator = new ExtendedCalculatorV1();
        System.out.println(calculator.isOdd(4.1));
        System.out.println(calculator.plus(5, 2));
        System.out.println(calculator.square(2));
        System.out.println(calculator.squareRoot(25));
    }
}
