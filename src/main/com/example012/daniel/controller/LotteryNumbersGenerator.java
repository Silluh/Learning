package main.com.example012.daniel.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.com.example012.daniel.domain.Game;
import main.com.example012.daniel.domain.Lottery;
import main.com.example012.daniel.domain.Ticket;

public class LotteryNumbersGenerator {

    private LotteryNumbersGenerator() {
    }

    private static final SecureRandom secureRandom = new SecureRandom();

    static List<Ticket> generateUserTickets(Game game) {

        return Stream.generate(() -> new Ticket(UUID.randomUUID().toString(),
                                                generateRandomNumbersByLottery(game.lottery())))
            .limit(game.countOfTickets())
            .toList();
    }

    public static Set<Integer> generateRandomNumbersByLottery(Lottery lottery) {

        int minNumber = 1;
        int maxNumber = lottery.getMaxNumber() + 1;

        return secureRandom.ints(minNumber, maxNumber)
            .distinct()
            .limit(lottery.getMaxGuessedNumbers())
            .boxed()
            .collect(Collectors.toCollection(TreeSet::new));
    }
}

