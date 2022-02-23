package main.com.example4.radek;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DrawMeSquareApplication {

    public static void main(String[] args) {


        int size = getEnteredValue("How big square you wanna draw ? ");
        String symbol = getEnteredValue();
        int variant = getEnteredValue("Test all 3 variants by typing 1,2 or 3");
        drawMeSquare(size, symbol, variant);
    }

    static void drawMeSquare(int size, String symbol, int variant) {

        switch (variant) {
            case 1:
                /*První varianta for cyklus a potom převod na IntStream a vykreslování pomocí forEach + lambda*/
                for (int i = 0; i < size; i++) {
                    final int finalI = i;
                    IntStream.range(0, size).forEach(result -> {
                        if (result == 0 || result == size - 1 || finalI == 0 || finalI == size - 1) {
                            System.out.print(symbol);
                        } else {
                            System.out.print(" ");
                        }

                    });
                    System.out.println();
                }
                break;
            case 2:
                /*Druhá varianta převodu na IntStream a pomocí forEach + lambda vykreslit*/
                IntStream.range(0, size).forEach(result -> {
                    IntStream.range(0, size).forEach(result2 -> {
                        if (result2 == 0 || result2 == size - 1 || result == 0 || result == size - 1) {
                            System.out.print(symbol);
                        } else {
                            System.out.print(" ");
                        }
                    });
                    System.out.println();
                });
                break;
            case 3:
                /*Třetí varianta 2x for cyklus*/
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if ((i == 0 || i == size - 1) || (j == 0 || j == size - 1)) {
                            System.out.print(symbol);
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Only variants 1,2 and 3 are valid!");
                break;
        }
    }

    static int getEnteredValue(String question) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        int value;
        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Insert number only!");
            value = 0;
            System.exit(0);
        }
        return value;
    }

    static String getEnteredValue() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which symbol you wanna use ?");
        return scanner.nextLine();
    }
}

