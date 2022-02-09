import java.util.Random;

public class Whole_RNG {
    public static void main(String[] args) {
        int count = args.length;
        if (count > 0) {
            Random rand = new Random();
            int Upperbound = 100;
            for (int row = 0; row < count; row++) {
                try {
                    int number = Integer.parseInt(args[row]);
                    for (int row_2 = 0; row_2 <= number; row_2++) {
                        if (row_2 == number) {
                            System.out.print("\r\n");
                        } else {
                            System.out.print(rand.nextInt(Upperbound) + " ");
                        }
                    }
                } catch (NumberFormatException nfe) {
                    System.out.print("Zadaný parametr není číslo !");
                }

            }
        }
        else {
            System.out.print("Musíte zadat parametr!");
        }
    }
}
