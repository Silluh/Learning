import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Whole_RNG {
    public static void main(String[] args) {
        System.out.println("Zadal jste hodnoty pomocí parametru ? 1 / 0 ");
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
                                System.out.println("Zadaný parametr není číslo !");
                            }

                        }
                    } else {
                        System.out.print("Musíte zadat parametr!");
                    }
                    break;
                case 0:
                    System.out.println("Zadejte počet požadovaných náhodných celých čísel");
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
                      System.out.println("Musíte zadat pouze číselnou hodnotu !");
                    }
                    break;
                default:
                    System.out.println("Zadejte 1 pro 'ANO' a 0 pro 'NE', jiná hodnota je chybná !");
                    break;
            }
        }
        catch (InputMismatchException nfe){
            System.out.println("Zadejte 1 pro 'ANO' a 0 pro 'NE', jiná hodnota je chybná !");
        }
    }
}
