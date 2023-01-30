package main.com.example010.radek.v2;

public interface BaseFighter {

    int getAttack();

    void attack(BaseFighter soldier);

    int getDefense();

    int getLife();

    String getName();

    void setLife(int life);

}