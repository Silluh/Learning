package main.com.example006.radek;

enum Operation {
    PLUS,
    MINUS,
    MULTI,
    DIVIDE
}

public class basicCalculatorApplication {

    public static void main(String[] args) {
        System.out.println(resolve(Operation.PLUS, 5, 2));
        System.out.println(resolve(Operation.MINUS, 5, 2));
        System.out.println(resolve(Operation.MULTI, 5, 2));
        System.out.println(resolve(Operation.DIVIDE, 5, 0));

    }

    static int resolve(Operation action, int value, int value2) {

        int result = 0;
        switch (action) {
            case PLUS:
                result = value + value2;
                break;
            case MINUS:
                result = value - value2;
                break;
            case MULTI:
                result = value * value2;
                break;
            case DIVIDE:
                if (value2 == 0) {
                    System.out.println("You cant divide with zero");
                    System.exit(0);
                    break;
                }
                result = value / value2;
                break;
        }
        return result;
    }

}
