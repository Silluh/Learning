package main.com.radek.example1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Whole_RNG {
    public static void main(String[] args) {
        System.out.println("Did you insert value by parameter ? 1 / 0 ");
        Scanner scanner = new Scanner(System.in);
        try {
            int answer = scanner.nextInt();
            switch(answer) {
                case 1:
                    int count_arg = args.length;
                    if (count_arg > 0) {
                        Random rand = new Random();
                        int Upperbound = 100;
                        for (int row = 0; row < count_arg; row++) {
                            try {
                                int number = Integer.parseInt(args[row]);
                                for (int row_2 = 0; row_2 <= number; row_2++) {
                                    if (row_2 == number) {
                                        System.out.println("");
                                    } else {
                                        System.out.print(rand.nextInt(Upperbound) + " ");
                                    }
                                }
                            } catch (NumberFormatException nfe) {
                                System.out.println("Entered value isn't number !");
                            }

                        }
                    } else {
                        System.out.print("You have to insert parameter!");
                    }
                    break;
                case 0:
                    System.out.println("Enter number of required random values");
                    try {
                        int count_input = scanner.nextInt();
                        if(count_input > 0) {
                            Random rand = new Random();
                            int Upperbound = 100;
                            for (int row = 0; row < count_input; row++) {
                                System.out.print(rand.nextInt(Upperbound) + " ");
                            }
                        }
                    }
                    catch (InputMismatchException nfe){
                      System.out.println("You have to insert parameter!");
                    }
                    break;
                default:
                    System.out.println("Enter 1 for 'YES' and 0 for 'NO', other values are not acceptable!");
                    break;
            }
        }
        catch (InputMismatchException nfe){
            System.out.println("Enter 1 for 'YES' and 0 for 'NO', other values are not acceptable!");
        }
    }
}
