package main.com.example012.v1.model;

import java.util.HashSet;
import java.util.UUID;

public class Ticket {

    private HashSet<Integer> lotteryTicketNumbers;
    private UUID id;

    public Ticket(HashSet<Integer> lotteryTicketNumbers, UUID id) {
        setLotteryTicketNumbers(lotteryTicketNumbers);
        setId(id);
    }

    public HashSet<Integer> getLotteryTicketNumbers() {
        return lotteryTicketNumbers;
    }

    public void setLotteryTicketNumbers(HashSet<Integer> lotteryTicketNumbers) {
        this.lotteryTicketNumbers = lotteryTicketNumbers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
