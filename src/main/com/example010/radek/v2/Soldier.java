package main.com.example010.radek.v2;

public class Soldier {

    private String name;
    private int life;

    public Soldier(String name, int life) {

        this.name = name;
        this.life = life;
    }

    public int attack() {

        return 0;
    }

    public void attack(Soldier soldier) {

    }

    public int defense() {

        return 0;
    }

    public int running() {

        return 0;
    }

    public String getName() {

        return name;
    }

    public int getLife() {

        return life;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLife(int life) {

        this.life = life;
    }
}
