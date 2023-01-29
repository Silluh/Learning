package main.com.example012.v1;

public class LotteryGameApplication {

    public static void main(String[] args) {

        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.lotteryGame(Company.SPORTKA, 100000);
        lotteryGame.sortResults();
        lotteryGame.printGameResults();
        LotteryGame lotteryGame2 = new LotteryGame();
        lotteryGame2.lotteryGame(Company.STASTNYCH10, 10000);
        lotteryGame2.sortResults();
        lotteryGame2.printGameResults();
    }
}
