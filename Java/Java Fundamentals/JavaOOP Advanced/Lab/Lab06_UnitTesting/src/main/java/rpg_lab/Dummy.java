package rpg_lab;

import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoots;

    public Dummy(int health, int experience, List<Weapon> possibleLoots) {
        this.health = health;
        this.experience = experience;
        this.possibleLoots = possibleLoots;
    }

    @Override
    public Weapon giveWeapon(RandomProvider rnd){
        if(!isDead()){
            throw new IllegalStateException("Target is not dead!");
        }

        int index = rnd.nextInt(possibleLoots.size());
        return possibleLoots.get(index);
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
