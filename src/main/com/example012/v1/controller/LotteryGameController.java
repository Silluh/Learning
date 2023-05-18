package main.com.example012.v1.controller;


import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.Ticket;
import main.com.example012.v1.view.LotteryGameView;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.UUID;

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
            HashSet<Integer> lotteryNumbers = generateUniqueNumbers();
            Ticket ticket = new Ticket(lotteryNumbers, UUID.randomUUID());
            tickets[i] = ticket;
        }
    }

    public void generateWinningTicket() {

        HashSet<Integer> lotteryNumbers = generateUniqueNumbers();
        winningTicket = new Ticket(lotteryNumbers, UUID.randomUUID());
    }

    public HashSet<Integer> generateUniqueNumbers() {

        HashSet<Integer> lotteryNumbers = new HashSet<>();
        while (!(lotteryNumbers.size() == lottery.getMaxGuessedNumbers())) {
            lotteryNumbers.add(random.nextInt(lottery.getMaxNumber()));
        }
        return lotteryNumbers;
    }

    public int totalCorrectNumbers(HashSet<Integer> numbers, HashSet<Integer> searchedNumber) {

        int correctNumbers = 0;
        for (int j : searchedNumber) {
            if (numbers.contains(j)) {
                correctNumbers++;
            }
        }
        return correctNumbers;
    }

    public int[] correctNumbersFromTickets() {

        int[] correctNumbers = new int[lottery.getMaxGuessedNumbers() + 1];
        for (Ticket ticket : tickets) {
            correctNumbers[totalCorrectNumbers(ticket.getLotteryTicketNumbers(), winningTicket.getLotteryTicketNumbers())]++;
        }
        return correctNumbers;
    }
}
