package main.com.example012.daniel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.com.example012.daniel.domain.Ticket;

public class LotteryResolver {

    private LotteryResolver() {
    }

    public static Map<Integer, Integer> resolve(Set<Integer> winningNumbers, List<Ticket> tickets) {

        var results = new HashMap<Integer, Integer>();

        for (Ticket ticket : tickets) {
            int countOfWinningNumbers = 0;
            for (Integer winningNumber : winningNumbers) {
                if (ticket.numbers().contains(winningNumber)) {
                    countOfWinningNumbers++;
                }
            }
            var numberOfWinningTicketsByCount = results.get(countOfWinningNumbers) == null
                                                ? 0
                                                : results.get(countOfWinningNumbers);

            results.put(countOfWinningNumbers, ++numberOfWinningTicketsByCount);
        }

        return results;
    }
}
