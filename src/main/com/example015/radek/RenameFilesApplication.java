package main.com.example015.radek;

import main.com.example015.radek.controller.FileManagerController;
import main.com.example015.radek.model.UserParameters;

public class RenameFilesApplication {

    public static void main(String[] args) {

        FileManagerController controller = new FileManagerController(new UserParameters());
        controller.renameFilesInFolder();
    }
}
