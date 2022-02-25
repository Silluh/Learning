package main.com.example005.radek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class printDiagonalsApplication {

    public static void main(String[] args) {

        int size = getEnteredValue();
        printDiagonals(DiagonalType.LEFT, size);
        printDiagonals(DiagonalType.RIGHT, size);
        printDiagonals(DiagonalType.BOTH, size);
    }

    static int getEnteredValue() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter size of diagonal: ");
        int value = 0;
        try {
            value = scanner.nextInt();

        } catch (InputMismatchException nfe) {
            System.out.println("You have to insert numeric value!");
            System.exit(0);
        }
        return value;
    }

    static void printDiagonals(DiagonalType type, int size) {

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                switch (type) {
                    case LEFT:
                        printLeft(column, row);
                        break;
                    case RIGHT:
                        printRight(size, column, row);
                        break;
                    case BOTH:
                        printBoth(size, column, row);
                        break;

                }
            }
            System.out.println();
        }
        System.out.println();

    }

    static void printLeft(int column, int row) {

        System.out.print(column == row ? "x" : " ");
    }

    static void printRight(int size, int column, int row) {

        System.out.print(column == size - row - 1 ? "x" : " ");
    }

    static void printBoth(int size, int column, int row) {

        System.out.print(column == row || column == size - row - 1 ? "x" : " ");
    }

}
