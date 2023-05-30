package main.com.example012.daniel.view;

import java.util.List;
import java.util.Map;
import java.util.Set;

import main.com.example012.daniel.domain.GameResultWrapper;
import main.com.example012.daniel.domain.Lottery;
import main.com.example012.daniel.domain.Ticket;

public class GameResultPrinter {

    private GameResultPrinter() {
    }

    public static void print(GameResultWrapper gameResultWrapper) {

        printLotteryInfo(gameResultWrapper.lottery(), gameResultWrapper.lotteryWinningNumbers());
//        printUserTickets(gameResultWrapper.generatedUserTickets());
        printResultTickets(gameResultWrapper.result());
    }

    private static void printLotteryInfo(Lottery lottery, Set<Integer> winningNumbers) {

        System.out.printf("Lottery %s%n", lottery.getCompany());

        winningNumbers.forEach(
            number -> System.out.print(number + "\t")
        );

        System.out.println();
    }

    private static void printResultTickets(Map<Integer, Integer> result) {

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.printf("Winning tickets with %d correct numbers is: %d \t", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }

    private static void printUserTickets(List<Ticket> tickets) {

        for (Ticket ticket : tickets) {
            ticket.numbers().forEach(
                number ->
                    System.out.print(number + "\t")
            );
            System.out.println();
        }
    }
}
