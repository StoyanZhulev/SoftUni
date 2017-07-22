package hardware;


import software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwareComponents;

    public Hardware(String name, String type){
        this.name = name;
        this.type = type;
        this.softwareComponents = new ArrayList<>();
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public List<Software> getSoftwareComponents() {
        return softwareComponents;
    }

    public int getCurrentCapacity() {
        int takenCapacity = 0;
        for (Software softwareComponent : softwareComponents) {
            takenCapacity += softwareComponent.getCapacityConsumption();
        }

        return this.maximumCapacity - takenCapacity;
    }

    public int getCurrentMemory() {
        int takenMemory = 0;
        for (Software softwareComponent : softwareComponents) {
            takenMemory += softwareComponent.getMemoryConsumption();
        }
        return this.maximumMemory - takenMemory;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public final void addSoftware(Software software) {
        this.softwareComponents.add(software);
    }

    public void removeSoftware(Software software) {
        this.softwareComponents.remove(software);
    }
    public int getExpressSoftwareCount(){
        int count = 0;
        for (Software softwareComponent : softwareComponents) {
            if(softwareComponent.getType().equals("expressSoftware")){
                count++;
            }
        }

        return count;
    }

    public int getLightSoftwareCount(){
        int count = 0;
        for (Software softwareComponent : softwareComponents) {
            if(softwareComponent.getType().equals("lightSoftware")){
                count++;
            }
        }

        return count;
    }

    public int getMemoryUsage(){
        int memoryUsage = 0;
        for (Software softwareComponent : softwareComponents) {
            memoryUsage += softwareComponent.getMemoryConsumption();
        }

        return memoryUsage;
    }

    public int getCapacityUsage(){
        int capacityUsage = 0;
        for (Software softwareComponent : softwareComponents) {
            capacityUsage += softwareComponent.getCapacityConsumption();
        }

        return capacityUsage;
    }
}
