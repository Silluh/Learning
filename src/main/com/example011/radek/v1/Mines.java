package main.com.example011.radek.v1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import static main.com.example011.radek.v1.StringConstant.*;

public class Mines {

    protected int playgroundSize;

    protected int numberOfMines;

    protected String[][] playground;

    private final int MINIMUM_PLAYGROUND_SIZE = 5;

    private final int MINIMUM_BOXES_PER_MINE = 10;

    public Mines(int size, int mines) {

        if (isPlaygroundBiggerThenLimit(size)) {
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
                playground[generatedRowNumber][generatedColumnNumber] = MINE.getValue();
                placedMines++;
            }
        }
    }

    private boolean isBoxNull(String value){

        return value == null;
    }

    private boolean isMineInBox(String value){

        return value.equals(MINE.getValue());
    }

    private boolean isBoxEmpty(String value){

        return value.equals(EMPTY_SLOT.getValue());
    }

    public void printPlayground(boolean showMines) {

        System.out.println("Generating playground...");
        StringBuilder playingField = new StringBuilder();
        for (int i = 0; i < playgroundSize; i++) {
            for (int j = 0; j < playgroundSize; j++) {
                if (!isBoxNull(playground[i][j]) && ((showMines && isMineInBox(playground[i][j]) || isBoxEmpty(playground[i][j])))) {
                    playingField.append(playground[i][j])
                            .append(TABULATOR.getValue());
                } else {
                    playingField.append(EMPTY.getValue())
                            .append(TABULATOR.getValue());
                }
            }
            playingField.append(NEW_LINE.getValue());
        }
        System.out.println(playingField);
    }

    public void printSizeAndMines() {

        System.out.println("Playground size is: " + playgroundSize + " and on this ground you can find: " + numberOfMines + " mines.");
    }

    private void setPlaygroundSize(int size) {

        playgroundSize = size;
    }

    private boolean isPlaygroundBiggerThenLimit(int size) {

        return size >= MINIMUM_PLAYGROUND_SIZE;
    }

    private int getPlaygroundSize() {

        return playgroundSize;
    }

    private boolean isThereMoreMinesThenBoxes(int mines){

       return mines >= (playgroundSize * playgroundSize);
    }

    private boolean isPlaygroundBigEnoughForOneMine(){

        return (playgroundSize * playgroundSize) < MINIMUM_BOXES_PER_MINE;
    }

    private boolean isPlaygroundBigEnoughToFitMines(int mines){

        return ((playgroundSize * playgroundSize) / mines) < MINIMUM_BOXES_PER_MINE;
    }

    private void setNumberOfMines(int mines) {

        if (isThereMoreMinesThenBoxes(mines)) {
            System.out.println("You can't have more mines, then you have playground size !");
            System.exit(0);
        } else if (isPlaygroundBigEnoughForOneMine()) {
            System.out.println("To place mine, you need playground of minimum size of 10 boxes!");
            System.exit(0);
        } else if (isPlaygroundBigEnoughToFitMines(mines)) {
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
                playground[rowNumber][columnNumber] = EMPTY_SLOT.getValue();
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
