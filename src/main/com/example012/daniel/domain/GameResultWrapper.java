package main.com.example012.daniel.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public record GameResultWrapper(

    Lottery lottery,
    List<Ticket> generatedUserTickets,
    Set<Integer> lotteryWinningNumbers,
    Map<Integer, Integer> result) {

    public static GameResultWrapperBuilder builder() {

        return new GameResultWrapperBuilder();
    }

    public static class GameResultWrapperBuilder {

        private Lottery lottery;
        private List<Ticket> generatedUserTickets;
        private Set<Integer> lotteryWinningNumbers;
        private Map<Integer, Integer> results;

        private GameResultWrapperBuilder() {
        }

        public GameResultWrapperBuilder lottery(final Lottery lottery) {
            this.lottery = lottery;
            return this;
        }

        public GameResultWrapperBuilder generatedUserTickets(final List<Ticket> generatedUserTickets) {
            this.generatedUserTickets = generatedUserTickets;
            return this;
        }

        public GameResultWrapperBuilder lotteryWinningNumbers(final Set<Integer> lotteryWinningNumbers) {
            this.lotteryWinningNumbers = lotteryWinningNumbers;
            return this;
        }

        public GameResultWrapperBuilder results(final Map<Integer, Integer> results) {
            this.results = results;
            return this;
        }


        public GameResultWrapper build() {

            return new GameResultWrapper(
                this.lottery,
                this.generatedUserTickets,
                this.lotteryWinningNumbers,
                this.results);
        }
    }
}
