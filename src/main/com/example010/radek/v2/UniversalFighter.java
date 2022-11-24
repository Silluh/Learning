package main.com.example010.radek.v2;

public class UniversalFighter extends Soldier {

    public UniversalFighter(String name, int life) {

        super(name, life);
    }

    public int attack() {

        return 10;
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

        return 10;
    }

    public int running() {

        return 10;
    }
}
