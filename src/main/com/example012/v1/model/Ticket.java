package main.com.example012.v1.model;

import java.util.UUID;

public class Ticket {

    private int[] lotteryTicketNumbers;
    private UUID id;

    public Ticket(int[] lotteryTicketNumbers, UUID id) {
        setLotteryTicketNumbers(lotteryTicketNumbers);
        setId(id);
    }

    public int[] getLotteryTicketNumbers() {
        return lotteryTicketNumbers;
    }

    public void setLotteryTicketNumbers(int[] lotteryTicketNumbers) {
        this.lotteryTicketNumbers = lotteryTicketNumbers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
