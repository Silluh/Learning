package main.com.example012.v1.view;

import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.StringConstant;

import java.util.Arrays;
import java.util.HashSet;


public class LotteryGameView {

    private final StringBuilder results = new StringBuilder();

    public void printResults(HashSet<Integer> winningNumbers, int numberOfTickets, Lottery lottery, int[] rightGuesses) {

        results.append("Game: ")
                .append(lottery.getCompany())
                .append(StringConstant.NEW_LINE)
                .append("Winning numbers: ");

        winningNumbers.forEach(c -> results.append(c)
                .append(StringConstant.TABULATOR));

        results.append(StringConstant.NEW_LINE)
                .append("Number of placed tickets: ")
                .append(numberOfTickets)
                .append(StringConstant.NEW_LINE);

        for (int i = 0; i <= lottery.getMaxGuessedNumbers(); i++) {
            results.append("Number of tickets with ")
                    .append(i)
                    .append(" right guesses: ")
                    .append(rightGuesses[i])
                    .append(StringConstant.NEW_LINE);
        }
        System.out.println(results);
    }
}
