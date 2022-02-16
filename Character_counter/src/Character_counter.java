import java.util.Scanner;


public class Character_counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert word");
        String input = scanner.nextLine();
        int input_size = input.length();
        int count;
        String[][] counted_chars = new String[input_size][input_size];
        for(int row=0;row< input_size; row++){
            char[] chars = new char[input_size];
            count = 0;
            if(row == 0){
                counted_chars[0][0] = Character.toString(input.charAt(0));
            }
            else{
                for(int row_2 = 0; row_2 < row; row_2++){
                    if( counted_chars[row_2][0]!= null) {
                        if (counted_chars[row_2][0].equals(Character.toString(input.charAt(row)))) {
                            count++;
                        }
                    }
                }
                if(count == 0){
                   counted_chars[row][0] = Character.toString(input.charAt(row));
                }
            }
            count = 0;
            for(int row_2 = 0; row_2 < input_size; row_2++){
                if(counted_chars[row][0] != null) {
                    if (counted_chars[row][0].equals(Character.toString(input.charAt(row_2)))) {
                        count++;
                    }
                }
            }
            counted_chars[row][1] = Integer.toString(count);
            if(row == 0){
                System.out.println("Your value consist of: ");
            }
            if(counted_chars[row][0] != null && counted_chars[row][1] != null){
                System.out.println(counted_chars[row][0] + " = " + counted_chars[row][1]);
            }
        }
    }
}
