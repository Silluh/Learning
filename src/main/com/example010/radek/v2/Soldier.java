package main.com.example010.radek.v2;

public class Soldier implements BaseFighter {

    private String name;
    private int life;

    public int attack() {

        return 0;
    }

    public void attack(Soldier soldier) {

        int damageDealt = attack() - soldier.defense();
        int remainingHealth = soldier.getLife() - damageDealt;
        soldier.setLife(remainingHealth);
        if (remainingHealth <= 0) {
            StringBuilder killMessage = new StringBuilder();
            System.out.println(killMessage.append(soldier.getName())
                    .append(" was killed !"));
        }
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

    public Soldier(String name, int life) {

        this.name = name;
        this.life = life;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLife(int life) {

        this.life = life;
    }
}
