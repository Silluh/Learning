package main.com.example012.v1.view;

import main.com.example012.v1.model.Lottery;

import java.util.Arrays;

import static main.com.example012.v1.model.StringConstant.*;

public class LotteryGameView {

    private StringBuilder results = new StringBuilder();

    public void printResults(int[] winningNumbers, int numberOfTickets, Lottery lottery, int[] rightGuesses) {

        results.append("Game: ")
                .append(lottery.getCompany())
                .append(NEW_LINE.getValue())
                .append("Winning numbers: ");

        Arrays.stream(winningNumbers).forEach(c -> results.append(c)
                .append(TABULATOR.getValue()));

        results.append(NEW_LINE.getValue())
                .append("Number of placed tickets: ")
                .append(numberOfTickets)
                .append(NEW_LINE.getValue());

        for (int i = 0; i <= lottery.getMaxGuessedNumbers(); i++) {
            results.append("Number of tickets with ")
                    .append(i)
                    .append(" right guesses: ")
                    .append(rightGuesses[i])
                    .append(NEW_LINE.getValue());
        }
        System.out.println(results);
    }
}
