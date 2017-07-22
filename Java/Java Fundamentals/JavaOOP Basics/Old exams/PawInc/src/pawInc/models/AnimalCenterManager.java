package pawInc.models;

import pawInc.models.animals.Animal;
import pawInc.models.animals.Cat;
import pawInc.models.animals.Dog;
import pawInc.models.centers.AdoptionCenter;
import pawInc.models.centers.CastrationCenter;
import pawInc.models.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CleansingCenter> cleansingCenters;
    private HashMap<String, CastrationCenter> castrationCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> addoptedAnimals;
    private List<Animal> castratedAnimals;

     public AnimalCenterManager(){
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters =new HashMap<>();
         this.castrationCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.addoptedAnimals = new ArrayList<>();
         this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name){
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(cleansingCenter.getName(),cleansingCenter);
    }

    public void registerAdoptionCenter(String name){
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(adoptionCenter.getName(),adoptionCenter);
    }

    public void registerCastrationCenter(String name){
        CastrationCenter castrationCenter = new CastrationCenter(name);
        this.castrationCenters.put(castrationCenter.getName(),castrationCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName){
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName){
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCastration(castrationCenter);
    }

    public void cleanse(String cleansingCenterName){
        List<Animal> cleansed = this.cleansingCenters.get(cleansingCenterName).cleanse();
        for (Animal animal : cleansed) {
            this.adoptionCenters.get(animal.getCenterName()).register(animal);
            this.cleansedAnimals.add(animal);
        }
    }

    public void castrate(String castrationCenter){
        List<Animal> cleansed = this.castrationCenters.get(castrationCenter).castrate();
        for (Animal animal : castratedAnimals) {
            this.adoptionCenters.get(animal.getCenterName()).register(animal);
            this.castratedAnimals.add(animal);
        }
    }

    public void adopt(String adoptionCenterName){
        List<Animal> adopt = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.addoptedAnimals.addAll(adopt);
    }

   public void printStatistics(){

        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.addoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingCoint()));
        sb.append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansingCount()));

        System.out.println(sb);
    }

    public void printCastrationStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics\n");
        sb.append(String.format("Castration Centers: %d\n", this.castrationCenters.size()));
        sb.append(String.format("Castrated Animals: %s\n", getSortedAnimals(this.castratedAnimals)));
        System.out.println(sb);
    }

    private int getAwaitingCleansingCount() {
        int  count = this.cleansingCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();
        return count;

    }

    private int getAwaitingCoint() {
        int  count = this.adoptionCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(a -> a.isCleansed())
                .collect(Collectors.toList())
                .size();
        return count;
    }

    private String getSortedAnimals(List<Animal> animals) {
        if(animals.isEmpty()){
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());
        return String.join(", ", sorted);
    }

}
