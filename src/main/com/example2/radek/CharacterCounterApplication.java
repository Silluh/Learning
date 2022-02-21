package main.com.example2.radek;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CharacterCounterApplication {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert word, which you want to count: ");
        String word = scanner.nextLine();
        if(word.length() > 0){
            char[] chars = word.toCharArray();
            /*
            * 1. Ze stringu vytvořit IntStream
            * 2. IntStream převedu na Stream (musím pochopit proč takový syntax)
            * 3. Stream Characteru vyberu distinctem a každý znak zobrazím
            * word.chars().mapToObj(e ->  Character.toString((char) e)).distinct().forEach(System.out::println);
            * Mám data v primitivním char array, mohu je převést do wrapper character array,
            * následně dát distinct a zobrazit, ale jak efektivně převést Char[] na Character[] (nutno zjistit)
            * Character[] characters = {'A', 'C', 'B', 'A'};
            * Arrays.stream(characters).distinct().forEach(System.out::println);
            */
            chars = getUniqueChars(chars);
            for(int i = 0; i < chars.length ; i++){
                if(chars[i] != 0) {
                    System.out.println(chars[i] + " " + getOccurrence(chars[i], word));
                }
            }
        }
    }

    static long getOccurrence(char chars, String word){

        long count;
        IntStream input = word.chars();
        count = input.filter(i -> i == chars).count();
        return count;
    }

    static char[] getUniqueChars(char[] chars){

        char[] unique_chars = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            int count = 0;
            for(int j = 0; j < unique_chars.length; j++){
                if(unique_chars[j] == chars[i]) {
                    count++;
                }
            }
            if(count == 0){
                unique_chars[i] = chars[i];
            }
        }
        return unique_chars;
    }
}
