package main.com.example010.radek.v2;

public class Defender extends Soldier {

    public Defender(String name, int life) {

        super(name, life);
    }

    @Override
    public int attack() {

        return 5;
    }

    @Override
    public int defense() {

        return 15;
    }

    @Override
    public int running() {

        return 10;
    }
}
