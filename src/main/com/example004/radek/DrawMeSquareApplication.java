package main.com.example004.radek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DrawMeSquareApplication {

    public static void main(String[] args) {

        int size = getEnteredValue("How big square you wanna draw ? ");
        String symbol = getEnteredValue();
        drawMeSquare(size, symbol);
    }

    static void drawMeSquare(int size, String symbol) {

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                System.out.print((isPositionPerimeter(row, size) || isPositionPerimeter(column, size)) ? symbol : " ");
            }
            System.out.println();
        }
    }

    static boolean isPositionPerimeter(int position, int size) {

        return position == 0 || position == size - 1;
    }

    static int getEnteredValue(String question) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        int value = 0;
        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Insert number only!");
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

