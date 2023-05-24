package main.com.example012.v1.view;

import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.StringConstant;

import java.util.Set;

public class LotteryGameView {

    private final StringBuilder results = new StringBuilder();

    public void printResults(Set<Integer> winningNumbers, int numberOfTickets, Lottery lottery, int[] rightGuesses) {

        printGameInfo(lottery);
        printWinningTicket(winningNumbers);
        printTicketsInfo(numberOfTickets);
        printRightGuesses(rightGuesses, lottery);
        System.out.println(results);
    }

    private void printGameInfo(Lottery lottery) {

        results.append("Game: ")
                .append(lottery.getCompany())
                .append(StringConstant.NEW_LINE);
    }

    private void printWinningTicket(Set<Integer> winningNumbers) {

        winningNumbers.forEach(c -> results.append(c)
                .append(StringConstant.TABULATOR));
    }

    private void printTicketsInfo(int numberOfTickets) {

        results.append(StringConstant.NEW_LINE)
                .append("Number of placed tickets: ")
                .append(numberOfTickets)
                .append(StringConstant.NEW_LINE);
    }

    private void printRightGuesses(int[] rightGuesses, Lottery lottery) {

        for (int i = 0; i <= lottery.getMaxGuessedNumbers(); i++) {
            results.append("Number of tickets with ")
                    .append(i)
                    .append(" right guesses: ")
                    .append(rightGuesses[i])
                    .append(StringConstant.NEW_LINE);
        }
    }
}
