package Pr08_PetClinic;

public class PetImpl{
    private String name;
    private int age;
    private String type;

    private PetImpl(String name, int age, String type) {
        this.setName(name);
        this.setAge(age);
        this.setType(type);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setType(String type) {
        this.type = type;
    }

    public static PetImpl createPet(String name, int age, String type) {
        return new PetImpl(name, age, type);
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.type);
    }
}
