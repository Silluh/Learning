package main.com.example010.radek.v1;

public class Soldier implements BaseFighter {

    @Override
    public int shooting() {
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
}
