package main.com.example012.daniel;

import main.com.example012.daniel.controller.GameController;
import main.com.example012.daniel.domain.Game;

import static main.com.example012.daniel.domain.Lottery.EUROJACKPOT;
import static main.com.example012.daniel.domain.Lottery.SPORTKA;
import static main.com.example012.daniel.domain.Lottery.STASTNYCH10;

public class LotteryDrawApplication {

    public static void main(String[] args) {

        Game sportka = new Game(SPORTKA, 50);
        Game luckyTen= new Game(STASTNYCH10, 50);
        Game eurojackpot = new Game(EUROJACKPOT, 50);

        GameController gameController = new GameController(sportka);
        gameController.play();
        System.out.println();

        GameController gameController2 = new GameController(luckyTen);
        gameController2.play();
        System.out.println();

        GameController gameController3 = new GameController(eurojackpot);
        gameController3.play();
        System.out.println();
    }
}