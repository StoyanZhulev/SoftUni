package pawInc.models.animals;

public abstract class Animal {
    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;
    private boolean cleansed;

    protected Animal(String name, int age){
        this.name = name;
        this.age = age;
    }



    protected Animal(String name, int age, String adoptionCenter){
        this(name, age);
        this.isCleansed = false;
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return name;
    }


    public boolean isCleansed() {
        return this.isCleansed;
    }

    public void cleanse() {
        this.isCleansed = true;
    }

    public String getCenterName() {
        return this.adoptionCenter;
    }
}
