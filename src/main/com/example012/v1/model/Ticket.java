package main.com.example012.v1.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Ticket {

    private Set<Integer> lotteryTicketNumbers = new HashSet<>();
    private UUID id;

    public Ticket(Set<Integer> lotteryTicketNumbers, UUID id) {
        setLotteryTicketNumbers(lotteryTicketNumbers);
        setId(id);
    }

    public Set<Integer> getLotteryTicketNumbers() {
        return lotteryTicketNumbers;
    }

    public void setLotteryTicketNumbers(Set<Integer> lotteryTicketNumbers) {
        this.lotteryTicketNumbers = lotteryTicketNumbers;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
