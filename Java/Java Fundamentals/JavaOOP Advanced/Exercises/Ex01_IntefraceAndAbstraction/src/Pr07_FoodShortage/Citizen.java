package Pr07_FoodShortage;

public class Citizen extends BaseEntity implements Identifiable, Personalizable,Buyer {
    private int age;
    private String id;
    private int food;


    public Citizen(String name, int age, String id, String birthDay) {
        super(name, birthDay);
        this.age = age;
        this.id = id;
        this.food = 0;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food+=10;
    }
}
