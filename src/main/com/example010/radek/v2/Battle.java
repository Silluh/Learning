package main.com.example010.radek.v2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Battle {

    public void battle(int rounds) throws NoSuchAlgorithmException {

        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Fighter("Maximus Decimus Meridius", 10));
        soldiers.add(new Universal("Commodus", 10));
        for (int i = 0; i < rounds; i++) {
            SecureRandom random = SecureRandom.getInstanceStrong();
            int attacker = random.nextInt(soldiers.size());
            for (int l = 0; l < soldiers.size(); l++) {
                if (l != attacker) {
                    soldiers.get(attacker).attack(soldiers.get(l));
                }
            }
            printSoldierStats(soldiers);
            soldiers = removeDeathFromList(soldiers);
        }
    }

    public List<Soldier> removeDeathFromList(List<Soldier> soldiers) {

        for (int l = soldiers.size() - 1; l >= 0; l--) {
            if (soldiers.get(l).getLife() <= 0) {
                soldiers.remove(l);
            }
        }
        if (soldiers.size() <= 1) {
            StringBuilder winnerBuilder = new StringBuilder();
            winnerBuilder.append("The winner is: ").append(soldiers.get(0).getName());
            System.out.println(winnerBuilder);
            System.exit(0);
        }
        return soldiers;
    }

    public void printSoldierStats(List<Soldier> soldiers) {

        StringBuilder resultBuilder = new StringBuilder();
        soldiers.forEach((c) -> resultBuilder.append("Name: ")
                .append(c.getName())
                .append("\t")
                .append(" Life: ")
                .append(c.getLife())
                .append("\n"));
        System.out.println(resultBuilder.append("----------------------------"));
    }

}
