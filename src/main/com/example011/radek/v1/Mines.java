package main.com.example011.radek.v1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Mines {

    protected int playgroundSize;

    protected int numMines;

    protected String[][] playground;

    public Mines(int size, int mines) {

        if (setPlaygroundSize(size)) {
            int setNumMinesResult = setNumMines(mines);
            if (setNumMinesResult == 1) {
                System.out.println("You can't have more mines, then you have playground size !");
                System.exit(0);
            } else if (setNumMinesResult == 2) {
                System.out.println("To place mine, you need playground of minimum size of 10 boxes!");
                System.exit(0);
            }
        } else {
            System.out.println("Bad size of playground, size must be bigger then 5!");
            System.exit(0);
        }
    }

    public void fillPlaygroundWithMines() throws NoSuchAlgorithmException {

        playground = new String[playgroundSize][playgroundSize];
        SecureRandom random = SecureRandom.getInstanceStrong();
        int placedMines = 0;
        while (placedMines != getNumMines() || placedMines == 0) {
            int generatedRowNumber = random.nextInt(playgroundSize);
            int generatedColumnNumber = random.nextInt(playgroundSize);
            if (playground[generatedRowNumber][generatedColumnNumber] == null) {
                playground[generatedRowNumber][generatedColumnNumber] = "x";
                placedMines = placedMines + 1;
            }
        }
    }

    public void printPlayground() throws NoSuchAlgorithmException {

        System.out.println("Generating playground...");
        String printMessage = "";
        for (int i = 0; i < playgroundSize; i++) {
            if (i > 0) {
                printMessage = printMessage + "\n";
            }
            for (int l = 0; l < playgroundSize; l++) {
                if (playground[i][l] == null) {
                    printMessage = printMessage + " " + "\t";
                } else {
                    printMessage = printMessage + playground[i][l] + "\t";
                }
            }
            if (i == playgroundSize - 1 && i == playgroundSize - 1) {
                System.out.println(printMessage);
            }
        }
    }

    public void getSizeAndMines() {

        System.out.println("Playground size is: " + playgroundSize + " and on this ground you can find: " + numMines + " mines.");
    }

    private boolean setPlaygroundSize(int size) {

        if (size >= 5) {
            playgroundSize = size;
            return true;
        }
        return false;
    }

    private int getPlaygroundSize() {

        return playgroundSize;
    }

    private int setNumMines(int mines) {

        int size = getPlaygroundSize();
        int returnValue = 0;
        if (mines >= (size * size)) {
            returnValue = 1;
        } else if ((size * size) < 10) {
            returnValue = 2;
        } else {
            numMines = mines;
        }
        return returnValue;
    }

    private int getNumMines() {

        return numMines;
    }

    private int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getValidRowNumber() {

        boolean validRow = false;
        System.out.println("Please choose row number: ");
        int rowInput = getUserInput();
        while (!validRow) {
            if (rowInput > getPlaygroundSize() || rowInput < 0) {
                System.out.println("Invalid row number, please type another one");
                rowInput = getUserInput();
                validRow = false;
            } else {
                validRow = true;
            }
        }
        return rowInput;
    }

    private int getValidColumnNumber() {

        boolean validColumn = false;
        System.out.println("Please choose column number: ");
        int columnInput = getUserInput();
        while (!validColumn) {
            if (columnInput > getPlaygroundSize() || columnInput < 0) {
                System.out.println("Invalid column number, please type another one");
                columnInput = getUserInput();
                validColumn = false;
            } else {
                validColumn = true;
            }
        }
        return columnInput;
    }

    public void playerMove() throws NoSuchAlgorithmException {

        int emptySpaceHit = 0;
        while (emptySpaceHit < (playgroundSize * playgroundSize) - numMines) {
            int rowNumber = getValidRowNumber();
            int columnNumber = getValidColumnNumber();
            if (playground[rowNumber][columnNumber] == "x") {
                System.out.println("You hit mine !");
                System.exit(0);
            } else {
                System.out.println("You hit empty slot");
                playground[rowNumber][columnNumber] = "o";
                emptySpaceHit = emptySpaceHit + 1;
            }
            printPlayground();
        }
        System.out.println("Congratulations ! You WON ! \n" +
                "( ͡° ͜ ͡°)"
        );
    }
}
