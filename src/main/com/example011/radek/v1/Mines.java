package main.com.example011.radek.v1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Mines {

    protected int playgroundSize;

    protected int numMines;

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

    public String[][] fillPlaygroundWithMines() throws NoSuchAlgorithmException {

        String[][] playground = new String[playgroundSize][playgroundSize];
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
        return playground;
    }

    public void printPlayground() throws NoSuchAlgorithmException {

        System.out.println("Generating playground...");
        String[][] playground = fillPlaygroundWithMines();
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
}
