package main.com.example012.v1;

import main.com.example012.v1.controller.LotteryGameController;
import main.com.example012.v1.model.Lottery;

public class LotteryGameApplicationV1 {

    public static void main(String[] args) {

        LotteryGameController lottery = new LotteryGameController(Lottery.SPORTKA, 100000);
        lottery.play();

        LotteryGameController lottery1 = new LotteryGameController(Lottery.STASTNYCH10, 50000);
        lottery1.play();
    }
}
