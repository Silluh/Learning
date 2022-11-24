package main.com.example010.radek.v2;

public class DefenderFighter extends Soldier implements BaseFighter {

    public DefenderFighter(String name, int life) {

        super(name, life);
    }

    public int attack() {

        return 5;
    }

    public int defense() {

        return 15;
    }

    public int running() {

        return 10;
    }
}
