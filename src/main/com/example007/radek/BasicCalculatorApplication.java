package main.com.example007.radek;

public class BasicCalculatorApplication {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(1, 2));
        System.out.println(calculator.minus(1, 2));
        System.out.println(calculator.multiply(1.2, 2.1));
        System.out.println(calculator.divide(1, 0));
    }
}
