package main.com.example4.radek;

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
                    System.out.print((isTrue(row, size)  || isTrue(column, size)) ? symbol : " ");
                }
                System.out.println();
            }
    }

    static boolean isTrue(int row, int size){

        return  row == 0 || row == size - 1 ? true: false;
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

