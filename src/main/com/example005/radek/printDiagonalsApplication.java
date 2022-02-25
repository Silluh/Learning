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
        try {
            return scanner.nextInt();
        } catch (InputMismatchException nfe) {
            System.out.println("You have to insert numeric value!");
            System.exit(0);
            return 0;
        }
    }

    static void printDiagonals(DiagonalType type, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size; j++) {
                switch (type) {
                    case LEFT:
                        System.out.print(j == i ? "x" : " ");
                        break;
                    case RIGHT:
                        System.out.print(j == size - i ? "x" : " ");
                        break;
                    case BOTH:
                        System.out.print(j == i || j == size - i ? "x" : " ");
                        break;

                }
            }
            System.out.println();
        }
        System.out.println();

    }

}
