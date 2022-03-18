package main.com.example009.radek.v3;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileService {

    boolean storeResultsIntoFile(List<Double> inputList) {

        boolean isStored = false;
        String name = getUserInput("Please insert file name: ", false);
        saveResultsIntoFile(name, inputList);
        return isStored;
    }

    boolean loadResultsFromFile() {

        try {
            String name = getUserInput("Please insert file name: ", true);
            BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"));
            reader.lines().forEach(System.out::println);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Connecting to file reader wasn't successful");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Reading from file wasn't successful");
            e.printStackTrace();
        }
        return true;
    }

    String getUserInput(String message, boolean checkExistence) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exists = doesFileExists(input);
        while ((exists == false || input == "exit") && checkExistence == true) {
            System.out.println("File name isn't correct try again, or type 'exit' to stop the program");
            input = getUserInput();
            exists = doesFileExists(input);
        }
        if (input.trim().length() == 0 && checkExistence == false) {
            System.out.println("Type valid file name, or type 'exit' to stop the program");
            input = getUserInput();
        }
        return input;
    }

    String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.trim().length() == 0) {
            getUserInput();
        } else if (input.equals("exit")) {
            System.exit(0);
        }
        return input;
    }

    boolean doesFileExists(String name) {

        File file = new File(name + ".txt");
        return file.exists();
    }

    void saveResultsIntoFile(String name, List<Double> inputText) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
            for (int i = 0; i < inputText.stream().count(); i++) {
                writer.write(String.valueOf(inputText.get(i)));
                writer.newLine();

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
