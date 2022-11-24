package main.com.example010.radek.v2;

public class RunnerFighter extends Soldier {

    public RunnerFighter(String name, int life) {

        super(name, life);
    }

    public int attack() {

        return 5;
    }

    public int defense() {

        return 5;
    }

    public int running() {

        return 20;
    }
}
