package Pr06_Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    protected void produceSound() {
        System.out.println("Give me one million b***h");
    }
}
