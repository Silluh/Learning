package main.com.example010.radek.v2;

public class Fighter extends Soldier implements BaseFighter {

    @Override
    public int attack() {

        return 15;
    }

    @Override
    public int defense() {

        return 5;
    }

    @Override
    public int running() {

        return 10;
    }

    public Fighter(String name, int life) {
        super(name, life);
    }


}
