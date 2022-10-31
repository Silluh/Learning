package main.com.example009.radek.v4;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileService {

    private String PATH_FILE_RESULTS = "src/main/com/example009/radek/v3/calculator-results/";
    private final JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


    void setPATH_FILE_RESULTS(String newPath) {

        PATH_FILE_RESULTS = newPath + "\\";
    }

    void storeResultsIntoFile(List<Double> inputList) {

        String fileName = getUserInput("Please insert file name where you want to save results: ");
        setPATH_FILE_RESULTS(getSaveDirectory());
        saveResultsIntoFile(fileName, inputList);
    }

    String getSaveDirectory() {

        fileChooser.setFileSelectionMode(fileChooser.DIRECTORIES_ONLY);
        int userDialogResult = fileChooser.showSaveDialog(null);
        if (userDialogResult != fileChooser.APPROVE_OPTION) {
            System.out.println("Directory selection was canceled, application will terminate!");
            System.exit(0);
        }
        return String.valueOf(fileChooser.getSelectedFile());
    }

    void loadResultsFromFile() {

        fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
        int fileFound = fileChooser.showOpenDialog(null);
        if (fileFound == fileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File wasn't selected or found!");
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
