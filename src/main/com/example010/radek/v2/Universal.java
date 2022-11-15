package main.com.example010.radek.v2;

public class Universal extends Soldier implements BaseFighter {

    @Override
    public int attack() {

        return 10;
    }

    @Override
    public int defense() {

        return 10;
    }

    @Override
    public int running() {

        return 10;
    }

    public Universal(String name, int life) {

        super(name, life);
    }
}
