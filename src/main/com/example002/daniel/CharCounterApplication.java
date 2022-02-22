package main.com.example002.daniel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCounterApplication {

    public static void main(String[] args) {

        String text = getEnteredText();
        Map<Character, Integer> parsedText = parseTextByEachCharacter(text);
        printResult(parsedText);

        // to cele lze zapsat takto, ale neni to citelne
        // printResult(parsedTextByEachCharacter(getEnteredText()));
    }

    private static String getEnteredText() {

        System.out.print("Write some text: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private static Map<Character, Integer> parseTextByEachCharacter(String text) {

        var result = new HashMap<Character, Integer>();

        for(char character : text.toCharArray()) {
            if(!result.containsKey(character)) {
                result.put(character, 0);
            }
            int currentCount = result.get(character);
            result.put(character, ++currentCount);
        }

        return result;
    }

    private static void printResult(Map<Character, Integer> parsedText) {

        for(Map.Entry<Character,Integer> entry : parsedText.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
