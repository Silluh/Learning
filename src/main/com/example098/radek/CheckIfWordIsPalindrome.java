package main.com.example098.radek;

import java.util.Arrays;
import java.util.Scanner;

public class CheckIfWordIsPalindrome {

    public static void main(String[] args) {

        String insertedText = getInsertedText();
        System.out.println(isTextPalindrome(insertedText));
    }

    static String getInsertedText(){

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    static boolean isTextPalindrome(String input){

        boolean isPalindrome = false;
        char[] inputBackwards = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            inputBackwards[i] =  input.toLowerCase().toCharArray()[input.length() - i - 1];
        }
        if(Arrays.equals(inputBackwards, input.toLowerCase().toCharArray())){
            isPalindrome = true;
        }
        
        return isPalindrome;
    }
}
