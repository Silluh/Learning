package main.com.example009.radek.v3;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileService {

    private final String PATH_FILE_RESULTS = "src/main/com/example009/radek/v3/calculator-results/";

    void storeResultsIntoFile(List<Double> inputList) {

        String name = getUserInput("Please insert file name where you want to save results: ");
        saveResultsIntoFile(name, inputList);
    }

    void loadResultsFromFile() throws IOException {

        try {
            String name = getCheckedUserInput("Please insert file name where you want to load results from: ");
            BufferedReader reader = new BufferedReader(new FileReader(PATH_FILE_RESULTS + name));
            reader.lines().forEach(System.out::println);
            reader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Connecting to file reader wasn't successful");
        } catch (IOException e) {
            throw new IOException("Reading from file wasn't successful");
        }
    }

    String getUserInput(String message) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty() || input.equals("exit")) {
            System.out.println("Type valid file name, or type 'exit' to stop the program");
            input = getUserInput();
        }
        return input;
    }

    String getCheckedUserInput(String message) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean exists = fileExists(input);
        while (!exists || input.equals("exit")) {
            System.out.println("File name isn't correct try again, or type 'exit' to stop the program");
            input = getUserInput();
            exists = fileExists(input);
        }
        if (input.isEmpty()) {
            System.out.println("Type valid file name, or type 'exit' to stop the program");
            input = getUserInput();
        }
        return input;
    }

    String getUserInput() {

        String input;
        do {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if (input.equals("exit")) {
                System.exit(0);
            }
        } while (input.isEmpty());

        return input;
    }

    boolean fileExists(String name) {

        File file = new File(PATH_FILE_RESULTS + name);
        return file.exists();
    }

    void saveResultsIntoFile(String name, List<Double> inputText) {

        try {
            createDirectory();
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_FILE_RESULTS + name));
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

        File file = new File(PATH_FILE_RESULTS);
        file.mkdirs();
    }
}
