package rpg_lab;

public interface Target {
    Weapon giveWeapon(RandomProvider rnd);

    int getHealth();

    void takeAttack(int attackPoints);

    int giveExperience();

    boolean isDead();

}
