package main.com.example010.radek.v2;

public class Runner extends Soldier implements BaseFighter {

    @Override
    public int attack() {

        return 5;
    }

    @Override
    public int defense() {

        return 5;
    }

    @Override
    public int running() {

        return 20;
    }

    public Runner(String name, int life) {

        super(name, life);
    }
}
