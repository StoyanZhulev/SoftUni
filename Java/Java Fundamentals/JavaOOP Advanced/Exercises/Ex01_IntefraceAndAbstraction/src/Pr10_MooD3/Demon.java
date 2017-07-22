package Pr10_MooD3;

public class Demon extends GameObject<Double>{

    public Demon(String userName, int level, double specialPoints) {
        super(userName, level, specialPoints);
        this.setHashedPassword(String.valueOf(userName.length() * 217));
    }

    @Override
    public String toString() {
        return super.toString() + this.getSpecialPoints() * this.getLevel();
    }
}
