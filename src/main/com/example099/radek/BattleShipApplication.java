package main.com.example099.radek;

import java.util.Random;

final class MyResult {
    private final int first;
    private final int second;

    public MyResult(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

public class BattleShipApplication {

    static int count = 0;
    static int shotsCounter = 0;
    static int[][] shotFired = new int[10][10];


    public static void main(String[] args) {

        int[][] board = getFilledArray();
        drawBoard(board);
        int i = 0;
        Random random = new Random();
        int shotX;
        int shotY;
        while(i < 100 && count < 13) {
            shotX = random.nextInt(10);
            shotY = random.nextInt(10);
            System.out.print(isHit(board, shotX ,  shotY ) + " " + i + " " + shotX + "/" + shotY + " ");
            i++;
        }
        System.out.println();
        System.out.println("hit counter: " +  count);

    }

    static int[][] getFilledArray(){

        int[][] returnArray = new int[10][10];
        MyResult results = getRandomPosition();
        returnArray = getShipPosition(returnArray, 5, results.getFirst(), results.getSecond());
        MyResult results2 = getRandomPosition();
        returnArray = getShipPosition(returnArray, 4, results2.getFirst(), results2.getSecond());
        MyResult results3 = getRandomPosition();
        returnArray = getShipPosition(returnArray, 4, results3.getFirst(), results3.getSecond());
        return returnArray;
    }

    static MyResult getRandomPosition(){

        Random random = new Random();
        boolean stop = false;
        int value = 0;
        int value1 = 0;
        while (stop == false){
            value = random.nextInt(10);
            value1 = random.nextInt(10);
            if(isShotAvailable(value, value1) == true) {
                stop = true;
                shotsCounter ++;
            }
        }
        return new MyResult(value, value1);

    }

    static int[][] getShipPosition(int[][] arrayInput, int shipSize, int startPositionX, int startPositionY){

        int[][] filledArray = arrayInput;
        if(startPositionX + shipSize <= 10){
            for(int i = 0; i < shipSize; i++){
                filledArray[startPositionX + i][startPositionY] = 1;
            }
        }else{
            for(int i = 0; i < shipSize; i++){
                filledArray[startPositionX - i][startPositionY] = 1;
            }
        }

        return filledArray;
    }

    static boolean isHit(int[][] inputArray, int x, int y){

        boolean value;
        if(inputArray[x][y] == 1){
            count ++;
            value = true;
        }
        else{
            value = false;
        }
        return value;
    }

    static void drawBoard(int[][] inputArray){

        for(int row = 0; row < inputArray.length; row ++){
            for(int column = 0; column < inputArray.length; column ++){
                System.out.print(inputArray[row][column] == 1 ? "x" : ".");
            }
            System.out.println();
        }
    }

    static boolean isShotAvailable(int value, int value1){

        boolean available = true;
        if(shotFired[value][value1] == 1){
            available = false;
        }else{
            shotFired[value][value1] = 1;
        }
        return available;
    }
}
