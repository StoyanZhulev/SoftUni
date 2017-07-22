package PawIncorporte;

import PawIncorporte.centers.AdoptionCenter;
import PawIncorporte.centers.CleansingCenter;

import java.util.ArrayList;
import java.util.List;

public class Paw {
    private List<AdoptionCenter> adoptionCenters;
    private List<CleansingCenter> cleansingCenters;
    private List<String> adoptedAnimals;
    private List<String> cleansedAnimals;

    public Paw(){
        this.adoptionCenters = new ArrayList<>();
        this.cleansingCenters = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
    }

    public void adoptedAnimal(String name){
        this.adoptedAnimals.add(name);
    }

    public void cleanedAnimal(String name){
        this.cleansedAnimals.add(name);
    }

    private String getAnimalswaitingForAdoption(){
        final int[] count = {0};
        for (AdoptionCenter adoptionCenter : adoptionCenters) {
           adoptionCenter.getAnimals().forEach(a -> {
               if(a.getCleansingStatus().equals("cleansed")){
                   count[0]++;
               }
           });
        }
        return String.valueOf(count[0]);
    }

    private String getAnimalsWaitingToBeCleaned(){
        final int[] count = {0};
        for (CleansingCenter cleansingCenter : cleansingCenters) {
            cleansingCenter.getAnimals().forEach(a -> {
                if(a.getCleansingStatus().equals("uncleansed")){
                    count[0]++;
                }
            });
        }
        return String.valueOf(count[0]);
    }

    public void addAdoptionCenter(AdoptionCenter adoptionCenter){
        this.adoptionCenters.add(adoptionCenter);
    }

    public void addCleansingCenter(CleansingCenter cleansingCenter){
        this.cleansingCenters.add(cleansingCenter);
    }

    public List<AdoptionCenter> getAdoptionCenters() {
        return adoptionCenters;
    }

    public List<CleansingCenter> getCleansingCenters() {
        return cleansingCenters;
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        output.append("Paw Incorporative Regular Statistics\n")
                .append("Adoption Centers: ").append(this.getAdoptionCenters().size()).append(System.lineSeparator())
                .append("Cleansing Centers: ").append(this.getCleansingCenters().size()).append(System.lineSeparator())
                .append("Adopted Animals: ");
        if(adoptedAnimals.size() > 0){
            adoptedAnimals.stream().sorted().forEach(a -> sb.append(a).append(", "));
            sb.delete(sb.length() - 2, sb.length());
            output.append(sb.toString()).append(System.lineSeparator());
        }else{
            output.append("None").append("\n");
        }
                output.append("Cleansed Animals: ");

        sb.delete(0, sb.length());
        if(cleansedAnimals.size() > 0){
            cleansedAnimals.stream().sorted().forEach(a -> sb.append(a).append(", "));
            sb.delete(sb.length() - 2, sb.length());
            output.append(sb.toString()).append(System.lineSeparator());
        }else{
            output.append("None").append("\n");
        }

                output.append("Animals Awaiting Adoption: ").append(getAnimalswaitingForAdoption()).append("\n")
                .append("Animals Awaiting Cleansing: ").append(getAnimalsWaitingToBeCleaned());

        return output.toString();
    }
}
