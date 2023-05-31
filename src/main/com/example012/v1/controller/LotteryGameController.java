package main.com.example012.v1.controller;

import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.Ticket;
import main.com.example012.v1.view.LotteryGameView;

import java.security.SecureRandom;
import java.util.*;

public class LotteryGameController {

    private final Lottery lottery;
    private Ticket winningTicket;
    private final Ticket[] tickets;
    private final LotteryGameView view = new LotteryGameView();
    private final int numberOfTickets;
    private final SecureRandom random = new SecureRandom();

    public LotteryGameController(Lottery lotteryType, int numberOfTickets) {

        this.lottery = lotteryType;
        this.numberOfTickets = numberOfTickets;
        this.tickets = new Ticket[numberOfTickets];
    }

    public void play() {

        generateTickets(numberOfTickets);
        generateWinningTicket();
        view.printResults(winningTicket.getLotteryTicketNumbers(), numberOfTickets, lottery, correctNumbersFromTickets());
    }

    public void generateTickets(int numberOfTickets) {

        for (int i = 0; i < numberOfTickets; i++) {
            Ticket ticket = new Ticket(generateUniqueNumbers(), UUID.randomUUID());
            tickets[i] = ticket;
        }
    }

    public void generateWinningTicket() {

        winningTicket = new Ticket(generateUniqueNumbers(), UUID.randomUUID());
    }

    private Set<Integer> generateUniqueNumbers() {

        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() != lottery.getMaxGuessedNumbers()) {
            uniqueNumbers.add(random.nextInt(lottery.getMaxNumber()) + 1);
        }
        return uniqueNumbers;
    }

    public int totalCorrectNumbers(Set<Integer> numbers, Set<Integer> searchedNumber) {

        int correctNumbers = 0;
        for (int j : searchedNumber) {
            if (numbers.contains(j)) correctNumbers++;
        }
        return correctNumbers;
    }

    public Map<Integer, Integer> correctNumbersFromTickets() {

        var correctNumbers = new HashMap<Integer, Integer>();
        int correctNumbersOnTicket;
        int numberOfCorrectNumbersOnTicket;
        for (Ticket ticket : tickets) {
            correctNumbersOnTicket = totalCorrectNumbers(ticket.getLotteryTicketNumbers(), winningTicket.getLotteryTicketNumbers());
            numberOfCorrectNumbersOnTicket = correctNumbers.get(correctNumbersOnTicket) == null ? 0 : correctNumbers.get(correctNumbersOnTicket);
            correctNumbers.put(correctNumbersOnTicket, ++numberOfCorrectNumbersOnTicket);
        }
        return correctNumbers;
    }
}
