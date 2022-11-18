package main.com.example011.radek.v1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Mines {

    protected int playgroundSize;

    protected int numberOfMines;

    protected String[][] playground;

    public Mines(int size, int mines) {

        if (checkPlaygroundSize(size)) {
            setPlaygroundSize(size);
            setNumberOfMines(mines);
        } else {
            System.out.println("Bad size of playground, size must be bigger then 5!");
            System.exit(0);
        }
    }

    public void fillPlaygroundWithMines() throws NoSuchAlgorithmException {

        playground = new String[playgroundSize][playgroundSize];
        SecureRandom random = SecureRandom.getInstanceStrong();
        int placedMines = 0;
        while (placedMines != getNumberOfMines() || placedMines == 0) {
            int generatedRowNumber = random.nextInt(playgroundSize);
            int generatedColumnNumber = random.nextInt(playgroundSize);
            if (playground[generatedRowNumber][generatedColumnNumber] == null) {
                playground[generatedRowNumber][generatedColumnNumber] = StringConstant.MINE.getConstant();
                placedMines++;
            }
        }
    }

    public void printPlayground(boolean showMines) {

        System.out.println("Generating playground...");
        StringBuilder playingField = new StringBuilder(playgroundSize * playgroundSize * 3);
        for (int i = 0; i < playgroundSize; i++) {
            for (int j = 0; j < playgroundSize; j++) {
                if (playground[i][j] != null && ((showMines && playground[i][j].equals("x")) || playground[i][j].equals("o"))) {
                    playingField.append(playground[i][j])
                            .append(StringConstant.TABULATOR.getConstant());
                } else {
                    playingField.append(StringConstant.EMPTY.getConstant())
                            .append(StringConstant.TABULATOR.getConstant());
                }
            }
            playingField.append(StringConstant.NEW_LINE.getConstant());
        }
        System.out.println(playingField);
    }

    public void getSizeAndMines() {

        System.out.println("Playground size is: " + playgroundSize + " and on this ground you can find: " + numberOfMines + " mines.");
    }

    private void setPlaygroundSize(int size) {

        playgroundSize = size;
    }

    private boolean checkPlaygroundSize(int size) {

        return size >= 5;
    }

    private int getPlaygroundSize() {

        return playgroundSize;
    }

    private void setNumberOfMines(int mines) {

        int size = getPlaygroundSize();
        if (mines >= (size * size)) {
            System.out.println("You can't have more mines, then you have playground size !");
            System.exit(0);
        } else if ((size * size) < 10) {
            System.out.println("To place mine, you need playground of minimum size of 10 boxes!");
            System.exit(0);
        } else if (((size * size) / mines) < 10) {
            System.out.println("There must be at least 10 boxes per 1 mine!");
            System.exit(0);
        } else {
            numberOfMines = mines;
        }
    }

    private int getNumberOfMines() {

        return numberOfMines;
    }

    private int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int getValidNumber() {

        System.out.println("Please choose row number: ");
        int numberInput = getUserInput();
        while (numberInput + 1 > getPlaygroundSize() || numberInput < 0) {
            System.out.println("Invalid row number, please type another one");
            numberInput = getUserInput();
        }
        return numberInput;
    }

    public void playerMove() {

        int emptySpaceHit = 0;
        while (emptySpaceHit < (playgroundSize * playgroundSize) - numberOfMines) {
            int rowNumber = getValidNumber();
            int columnNumber = getValidNumber();
            if (playground[rowNumber][columnNumber] == null || playground[rowNumber][columnNumber].equals("o")) {
                System.out.println("You hit empty slot");
                playground[rowNumber][columnNumber] = StringConstant.EMPTY_SLOT.getConstant();
                emptySpaceHit++;
            } else {
                printPlayground(true);
                System.out.println("You hit mine ! You LOSE ! \n( ͡° ︵ ͡°)");
                System.exit(0);
            }
            printPlayground(false);
        }
        System.out.println("Congratulations ! You WON ! \n( ͡° ͜ ͡°)");
    }
}
