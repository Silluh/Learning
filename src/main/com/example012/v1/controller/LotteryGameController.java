package main.com.example012.v1.controller;


import main.com.example012.v1.model.Lottery;
import main.com.example012.v1.model.Ticket;
import main.com.example012.v1.view.LotteryGameView;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;

public class LotteryGameController {

    private Lottery lottery;
    private Ticket WinningTicket;
    private Ticket[] tickets;
    private LotteryGameView view = new LotteryGameView();
    private SecureRandom random = new SecureRandom();

    public LotteryGameController(Lottery lotteryType, int numberOfTickets) {
        this.lottery = lotteryType;
        this.tickets = new Ticket[numberOfTickets];
        generateTickets(numberOfTickets);
        generateWinningTicket();
        view.printResults(WinningTicket.getLotteryTicketNumbers(), numberOfTickets, lotteryType, correctNumbersFromTickets());

    }

    public void generateTickets(int numberOfTickets) {

        for (int i = 0; i < numberOfTickets; i++) {
            int[] lotteryNumbers = generateUniqueNumbers();
            Ticket ticket = new Ticket(lotteryNumbers, UUID.randomUUID());
            tickets[i] = ticket;
        }
    }

    public void generateWinningTicket() {

        int[] lotteryNumbers = generateUniqueNumbers();
        WinningTicket = new Ticket(lotteryNumbers, UUID.randomUUID());
    }

    public int[] generateUniqueNumbers() {

        int[] lotteryNumbers = new int[lottery.getMaxGuessedNumbers()];
        for (int j = 0; j < lottery.getMaxGuessedNumbers(); j++) {
            int randomNumber = random.nextInt(lottery.getMaxNumber());
            if (uniqueNumberInArray(lotteryNumbers, randomNumber)) {
                lotteryNumbers[j] = randomNumber;
            } else {
                j--;
            }
        }
        return lotteryNumbers;
    }

    public boolean uniqueNumberInArray(int[] numbers, int searchedNumber) {

        if (!Arrays.stream(numbers).boxed().toList().contains(searchedNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public int totalCorrectNumbers(int[] numbers, int[] searchedNumber) {

        int correctNumbers = 0;
        for(int i = 0; i < searchedNumber.length; i++){
            if (Arrays.stream(numbers).boxed().toList().contains(searchedNumber[i])) {
                correctNumbers++;
            }
        }
        return correctNumbers;
    }

    public int[] correctNumbersFromTickets(){

        int[] correctNumbers = new int[lottery.getMaxGuessedNumbers() + 1];
        for(int i = 0; i < tickets.length; i++){
            correctNumbers[totalCorrectNumbers(tickets[i].getLotteryTicketNumbers(), WinningTicket.getLotteryTicketNumbers())] ++;
        }
        return correctNumbers;
    }
}
