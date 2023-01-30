package main.com.example010.radek.v2;

public class FighterFighter implements BaseFighter{

    private String name;

    private int life;

    public FighterFighter(String name, int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public int getAttack() {

        return 15;
    }

    @Override
    public void attack(BaseFighter soldier) {

        int damageDealt = getAttack() - soldier.getDefense();
        int remainingHealth = soldier.getLife() - damageDealt;
        soldier.setLife(remainingHealth);
        if (remainingHealth <= 0) {
            StringBuilder killMessage = new StringBuilder();
            System.out.println(killMessage.append(soldier.getName())
                    .append(" was killed !"));
        }
    }

    @Override
    public int getDefense() {

        return 5;
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
