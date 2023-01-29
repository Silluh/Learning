package main.com.example012.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static main.com.example012.v1.StringConstant.*;

public class LotteryGame {

    private Company gameType;

    private Tickets winningTicket;

    private final StringBuilder tickets = new StringBuilder();

    private final List<Tickets> otherTickets = new ArrayList<>();

    public void lotteryGame(Company gameType, int numberOfDraws) {

        setGameType(gameType);
        initGameTicket();
        for (int i = 0; i < numberOfDraws; i++) {
            otherTickets.add(new Tickets().tickets(gameType));
            otherTickets.get(i).setCorrectNumbers(winningTicket);
        }
    }

    public void sortResults() {

        otherTickets.sort(Comparator.comparing(Tickets::getCorrectNumbers).reversed());
    }

    public void printGameResults() {

        tickets.append("Game: ")
                .append(gameType.getCompany())
                .append(NEW_LINE.getValue());
        addFormattedWinningTicketResultToPrint();
        addMaximumGuessedNumbers();
        System.out.println(tickets);
    }

    private void addFormattedWinningTicketResultToPrint() {

        tickets.append("Winning ticket have these numbers: ");
        Arrays.stream(winningTicket.getLotteryTicketNumbers()).forEach(c -> tickets.append(c)
                .append(TABULATOR.getValue()));
        tickets.append(NEW_LINE.getValue());
    }

    private void addMaximumGuessedNumbers() {

        for (int i = 0; i <= gameType.maxGuessedNumbers; i++) {
            int k = i;
            List<Tickets> ticketsWithSameGuessedNumbers = otherTickets
                    .stream()
                    .filter(c -> c.getCorrectNumbers() == k)
                    .toList();
            tickets.append("Number of tickets with ")
                    .append(i)
                    .append(" right guesses: ")
                    .append(ticketsWithSameGuessedNumbers.size())
                    .append(NEW_LINE.getValue());
        }
    }

    public void setGameType(Company gameType) {

        this.gameType = gameType;
    }

    public void initGameTicket() {

        winningTicket = new Tickets();
        winningTicket.tickets(gameType);
    }
}
