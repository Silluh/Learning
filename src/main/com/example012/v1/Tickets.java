package main.com.example012.v1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;

public class Tickets {

    private int[] lotteryTicketNumbers;

    private UUID id;

    private Company gameType;

    private int correctNumbers;

    public Tickets tickets(Company gameType) {

        this.gameType = gameType;
        setLotteryTicketNumbers();
        setId();
        return this;
    }

    private void setId() {

        this.id = UUID.randomUUID();
    }

    public void setLotteryTicketNumbers() {

        this.lotteryTicketNumbers = generateUniqueLotteryNumbers();
    }

    private int[] generateUniqueLotteryNumbers() {

        int[] lotteryNumbers = new int[gameType.maxGuessedNumbers];
        for (int i = 0; i < gameType.getMaxGuessedNumbers(); i++) {
            boolean isNumberUnique = false;
            int randomNumber = 0;
            while (!isNumberUnique) {
                randomNumber = getRandomNumber();
                if (!Arrays.stream(lotteryNumbers).boxed().toList().contains(randomNumber)) {
                    isNumberUnique = true;
                }
            }
            lotteryNumbers[i] = randomNumber;
        }
        return lotteryNumbers;
    }

    private int getRandomNumber() {
        int randomNumber = 0;
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            while (randomNumber < 1) {
                randomNumber = random.nextInt(gameType.maxNumber + 1);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occurred while generating random number: " + e.getMessage());
        }
        return randomNumber;
    }

    public int[] getLotteryTicketNumbers() {

        return lotteryTicketNumbers;
    }

    public UUID getId() {

        return id;
    }

    public int getCorrectNumbers() {

        return correctNumbers;
    }

    public void setCorrectNumbers(Tickets winningTicket) {

        int correctNumbers = 0;
        for (int i : winningTicket.getLotteryTicketNumbers()) {
            for (int j : lotteryTicketNumbers) {
                if (i == j) {
                    correctNumbers++;
                }
            }
        }
        this.correctNumbers = correctNumbers;
    }
}
