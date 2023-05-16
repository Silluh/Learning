package main.com.example015.radek.controller;

import main.com.example015.radek.model.UserParameters;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

import static main.com.example015.radek.model.StringConstant.*;

public class FileManagerController {

    private final UserParameters user;

    public FileManagerController(UserParameters user) {
        this.user = user;
        initUser();
    }

    public void renameFilesInFolder() {
        File actual = user.getFile();
        for (File f : Objects.requireNonNull(actual.listFiles())) {
            File newFile = new File(user.getPath() + File.separator + getNewFileName(f.getName()));
            if (!f.renameTo(newFile)) {
                System.out.println("Renaming file: " +
                        f.getName() +
                        " to: " +
                        getNewFileName(f.getName()) +
                        " has failed!");
            }
        }
    }

    public String getNewFileName(String fileName) {

        fileName = fileName.replace(FIND.getValue().subSequence(0, FIND.getValue().length()), REPLACE.getValue().subSequence(0, REPLACE.getValue().length()));
        fileName = fileName.replace(FIND_2.getValue().subSequence(0, FIND_2.getValue().length()), REPLACE_2.getValue().subSequence(0, REPLACE_2.getValue().length()));

        return fileName;
    }

    public String getInput(String message) {
        System.out.println(message);
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (input == null || input.trim().isEmpty()) {
            input = scanner.nextLine();
        }
        return input;
    }

    public void initUser() {

        user.setPath(getInput("Please select path"));
        user.setFiles(new File(user.getPath()));
    }
}
