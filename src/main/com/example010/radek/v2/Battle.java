package main.com.example010.radek.v2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Battle {

    private int rounds;

    private List<Soldier> soldiers = new ArrayList<>();

    public void battle() throws NoSuchAlgorithmException {

        for (int i = 0; i < rounds; i++) {
            SecureRandom random = SecureRandom.getInstanceStrong();
            int attacker = random.nextInt(soldiers.size());
            for (int l = 0; l < soldiers.size(); l++) {
                if (l != attacker) {
                    soldiers.get(attacker).attack(soldiers.get(l));
                }
            }
            removeDeathSoldiers();
            printSoldierStats();
        }
    }

    public void removeDeathSoldiers() {

        for (int l = soldiers.size() - 1; l >= 0; l--) {
            if (soldiers.get(l).getLife() <= 0) {
                soldiers.remove(l);
            }
        }
    }

    public void printSoldierStats() {

        StringBuilder soldierStatistic = new StringBuilder();
        if (soldiers.size() <= 1) {
            soldierStatistic.append("The winner is: ")
                    .append(soldiers.get(0).getName());
            System.out.println(soldierStatistic);
            System.exit(0);
        }
        soldiers.forEach((c) -> soldierStatistic.append("Name: ")
                .append(c.getName())
                .append("\t")
                .append(" Life: ")
                .append(c.getLife())
                .append("\n"));
        System.out.println(soldierStatistic.append("----------------------------"));
    }

    public void setRounds(int rounds) {

        this.rounds = rounds;
    }

    public void addSoldier(Soldier soldier) {

        soldiers.add(soldier);
    }
}
