package main.com.example010.radek.v2;

public class FighterFighter extends Soldier {

    public FighterFighter(String name, int life) {
        super(name, life);
    }


    public int attack() {

        return 15;
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

        return 5;
    }

    public int running() {

        return 10;
    }
}
