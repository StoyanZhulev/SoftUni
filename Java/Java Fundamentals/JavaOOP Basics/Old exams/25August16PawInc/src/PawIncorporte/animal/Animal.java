package PawIncorporte.animal;

import PawIncorporte.centers.AdoptionCenter;

public abstract class Animal {
    private String name;
    private String age;
    private String cleansingStatus;
    private AdoptionCenter adoptionCenter;

    public Animal(String name, String age, AdoptionCenter adoptionCenter){
        this.name = name;
        this.age = age;
        this.adoptionCenter = adoptionCenter;
        this.cleansingStatus = "uncleansed";
    }

    public String getName() {
        return name;
    }

    public String getCleansingStatus() {
        return cleansingStatus;
    }

    public AdoptionCenter getAdoptionCenter() {
        return adoptionCenter;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }
}
