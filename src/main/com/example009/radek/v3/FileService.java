package main.com.example009.radek.v3;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileService {

    final private String path = "src/main/com/example009/radek/v3/calculator-results/";

    void storeResultsIntoFile(List<Double> inputList) {

        String name = getUserInput("Please insert file name: ", false);
        saveResultsIntoFile(name, inputList);
    }

    void loadResultsFromFile() {

        try {
            String name = getUserInput("Please insert file name: ", true);

            BufferedReader reader = new BufferedReader(new FileReader(path + name));
            reader.lines().forEach(System.out::println);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Connecting to file reader wasn't successful");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Reading from file wasn't successful");
            e.printStackTrace();
        }
    }

    String getUserInput(String message, boolean checkExistence) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exists = doesFileExists(input);
        while ((!exists || input.equals("exit")) && checkExistence) {
            System.out.println("File name isn't correct try again, or type 'exit' to stop the program");
            input = getUserInput();
            exists = doesFileExists(input);
        }
        if (input.isEmpty() && !checkExistence) {
            System.out.println("Type valid file name, or type 'exit' to stop the program");
            input = getUserInput();
        }
        return input;
    }

    String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                System.exit(0);
            }
        } while (input.isEmpty());

        return input;
    }

    boolean doesFileExists(String name) {

        File file = new File(path + name);
        return file.exists();
    }

    void saveResultsIntoFile(String name, List<Double> inputText) {

        try {
            createDirectory();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + name));
            for (int i = 0; i < (long) inputText.size(); i++) {
                writer.write(String.valueOf(inputText.get(i)));
                writer.newLine();

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createDirectory() {

        File file = new File(path);
        file.mkdirs();
    }
}
