package Pr06_Animals;

public class Kitten extends Cat {
    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    protected void produceSound() {
        System.out.println("Miau");
    }
}
