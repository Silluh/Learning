package main.com.radek.example2;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CharacterCounterByRadekApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert word, which you want to count: ");
        String Word = scanner.nextLine();
        if(Word.length() > 0){
            char[] chars = Word.toCharArray();
            System.out.println(chars);
            for(int i = 0; i < Word.length(); i++){
                System.out.println(chars[i] + " " + getOccurence(chars[i], Word));
            }
        }
    }
    static long getOccurence(char chars, String word){
        long count = 0;
        IntStream Input = word.chars();
        count = Input.filter(i -> i == chars).count();
        return count;
    }
}
