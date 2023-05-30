package main.com.example012.daniel.controller;

import main.com.example012.daniel.domain.Game;
import main.com.example012.daniel.domain.GameResultWrapper;
import main.com.example012.daniel.view.GameResultPrinter;

public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void play() {

        var generatedUserTickets = LotteryNumbersGenerator.generateUserTickets(game);
        var lotteryWinningNumbers = LotteryNumbersGenerator.generateRandomNumbersByLottery(game.lottery());
        var result = LotteryResolver.resolve(lotteryWinningNumbers, generatedUserTickets);

        GameResultPrinter.print(
            GameResultWrapper
                .builder()
                .lottery(game.lottery())
                .generatedUserTickets(generatedUserTickets)
                .lotteryWinningNumbers(lotteryWinningNumbers)
                .results(result)
                .build()
        );
    }
}