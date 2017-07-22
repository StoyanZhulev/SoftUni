package Pr10_MooD3;

public class Archangel extends GameObject<Integer>{
    public Archangel(String userName, int level, int specialPoints) {
        super(userName, level, specialPoints);
        this.setHashedPassword(String.valueOf(new StringBuilder(userName).reverse().append(userName.length() * 21)));
    }

    @Override
    public String toString() {
        return super.toString() + this.getSpecialPoints() * this.getLevel();
    }
}
