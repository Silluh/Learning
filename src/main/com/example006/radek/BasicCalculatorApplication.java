package main.com.example006.radek;


import static main.com.example006.radek.Operation.*;

public class BasicCalculatorApplication {

    public static void main(String[] args) {
        System.out.println(resolve(PLUS, 5, 2));
        System.out.println(resolve(MINUS, 5, 2));
        System.out.println(resolve(MULTI, 5, 2));
        System.out.println(resolve(DIVIDE, 5, 0));

    }

    static int resolve(Operation action, int value, int value2) {

        int result = 0;
        switch (action) {
            case PLUS -> result = value + value2;
            case MINUS -> result = value - value2;

            case MULTI -> result = value * value2;

            case DIVIDE -> {
                if (value2 == 0) {
                    System.out.println("You cant divide with zero");
                    System.exit(0);
                }
                result = value / value2;
            }
        }
        return result;
    }

}
