package main.com.example012.v1.view;

import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.StringConstant;

import java.util.Map;
import java.util.Set;

public class LotteryGameView {

    private final StringBuilder results = new StringBuilder();

    public void printResults(Set<Integer> winningNumbers, int numberOfTickets, Lottery lottery, Map<Integer, Integer> rightGuesses) {

        printGameInfo(lottery);
        printWinningTicket(winningNumbers);
        printTicketsInfo(numberOfTickets);
        printRightGuesses(rightGuesses);
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

    private void printRightGuesses(Map<Integer, Integer> rightGuesses) {

        rightGuesses.forEach((key, value) -> results.append("Number of tickets with ")
                .append(key)
                .append(" right guesses: ")
                .append(value)
                .append(StringConstant.NEW_LINE));
    }
}
