package main.com.example010.radek.v2;

public class Fighter extends Soldier {

    public Fighter(String name, int life) {
        super(name, life);
    }

    @Override
    public int attack() {

        return 15;
    }

    @Override
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

    @Override
    public int defense() {

        return 5;
    }

    @Override
    public int running() {

        return 10;
    }
}
