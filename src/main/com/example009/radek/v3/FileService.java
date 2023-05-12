package main.com.example009.radek.v3;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileService {

    private final String PATH_FILE_RESULTS = "src/main/resources/example009/v3/";

    void storeResultsIntoFile(List<Double> inputList) {

        String name = getUserInput("Please insert file name where you want to save results: ");
        saveResultsIntoFile(name, inputList);
    }

    void loadResultsFromFile(String name) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_FILE_RESULTS + name))) {
            reader.lines().forEach(System.out::println);
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
            System.out.println("Type valid response, or type 'exit' to stop the program");
            input = getUserInput();
        }
        return input;
    }

    int getUserIntInput() {

        System.out.println("Please insert file number or type '0' to end program");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            System.exit(0);
        }
        return input;
    }

    String getCheckedUserInput() {

        System.out.println("Please insert file name where you want to load results from: ");
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

    void loadPreviousResultFile() throws IOException {

        File directory = new File(PATH_FILE_RESULTS);
        String[] files = directory.list();
        if (anyFileExist(directory) && shouldLoadResultsFromFile()) {
            StringBuilder previousFiles = new StringBuilder(Objects.requireNonNull(files).length);
            for (int i = 0; i < files.length; i++) {
                previousFiles.append(i + 1)
                        .append(" - ")
                        .append(files[i])
                        .append("\n");
            }
            System.out.println(previousFiles);
            int fileNumber = getUserIntInput();
            if (fileNumber - 1 <= files.length) {
                loadResultsFromFile(files[fileNumber - 1]);
                System.exit(0);
            }
        }
    }

    boolean anyFileExist(File directory) {

        String[] files = directory.list();
        return files != null && files.length > 0;
    }

    boolean shouldLoadResultsFromFile() {

        String input = getUserInput("Do you want to load previous results ? yes/no");
        return input.equals("yes");
    }

    boolean fileExists(String name) {

        File file = new File(PATH_FILE_RESULTS + name);
        return file.exists();
    }

    void saveResultsIntoFile(String name, List<Double> inputText) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_FILE_RESULTS + name))) {
            createDirectory();
            for (int i = 0; i < (long) inputText.size(); i++) {
                writer.write(String.valueOf(inputText.get(i)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createDirectory() {

        File file = new File(PATH_FILE_RESULTS);
        if (file.mkdirs()) {
            System.out.println("Directory was created successfully");
        } else {
            System.out.println("Directory wasn't created");
        }
    }
}
