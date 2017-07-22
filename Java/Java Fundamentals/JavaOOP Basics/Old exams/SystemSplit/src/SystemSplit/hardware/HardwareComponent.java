package SystemSplit.hardware;

import SystemSplit.Component;
import SystemSplit.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class HardwareComponent extends Component{
    private int maximumCapacity;
    private int maximumMemory;
    private List<SoftwareComponent> softwareComponents;

    public HardwareComponent(String name, String type) {
        super(name, type);
        this.softwareComponents = new ArrayList<>();
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }


    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public List<SoftwareComponent> getSoftwareComponents() {
        return softwareComponents;
    }

    public int getCurrentCapacity() {
        int takenCapacity = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            takenCapacity += softwareComponent.getCapacityConsumption();
        }

        return this.maximumCapacity - takenCapacity;
    }

    public int getCurrentMemory() {
        int takenMemory = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            takenMemory += softwareComponent.getMemoryConsumption();
        }
        return this.maximumMemory - takenMemory;
    }

    public void removeSoftware(SoftwareComponent software) {
        this.softwareComponents.remove(software);
    }

    public int getExpressSoftwareCount(){
        int count = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            if(softwareComponent.getType().equals("expressSoftware")){
                count++;
            }
        }

        return count;
    }
    public int getLightSoftwareCount(){
        int count = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            if(softwareComponent.getType().equals("lightSoftware")){
                count++;
            }
        }

        return count;
    }

    public int getMemoryUsage(){
        int memoryUsage = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            memoryUsage += softwareComponent.getMemoryConsumption();
        }

        return memoryUsage;
    }

    public int getCapacityUsage(){
        int capacityUsage = 0;
        for (SoftwareComponent softwareComponent : softwareComponents) {
            capacityUsage += softwareComponent.getCapacityConsumption();
        }

        return capacityUsage;
    }

    public void registerSoftwareComponent(SoftwareComponent software) {
        this.softwareComponents.add(software);
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getMemory() {
        return 0;
    }

}
