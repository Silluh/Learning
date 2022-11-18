package main.com.example010.radek.v2;

import java.security.NoSuchAlgorithmException;

public class FightingGameApplicationV2 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Battle battle = new Battle();
        battle.setRounds(5);
        battle.addSoldier(new Fighter("Maximus Decimus Meridius", 10));
        battle.addSoldier(new Universal("Commodus", 10));
        battle.battle();
    }
}
