package main.com.example011.radek.v1;

import java.security.NoSuchAlgorithmException;

public class MinesGameApplication {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Mines mines = new Mines(10, 99);
        mines.getSizeAndMines();
        mines.printPlayground();
    }
}
