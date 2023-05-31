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

        GameController sportkaGameController = new GameController(sportka);
        sportkaGameController.play();
        System.out.println();

        GameController luckyTenController = new GameController(luckyTen);
        luckyTenController.play();
        System.out.println();

        GameController eurojackpotController = new GameController(eurojackpot);
        eurojackpotController.play();
        System.out.println();
    }
}