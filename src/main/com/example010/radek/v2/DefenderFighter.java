package main.com.example010.radek.v2;

public class DefenderFighter implements BaseFighter {

    private String name;

    private int life;

    public DefenderFighter(String name, int life) {

        this.name = name;
        this.life = life;
    }

    @Override
    public int getAttack() {

        return 5;
    }

    @Override
    public void attack(BaseFighter soldier) {

    }

    @Override
    public int getDefense() {

        return 15;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }
}
