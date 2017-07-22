package SystemSplit.software;

import SystemSplit.Component;

public abstract class SoftwareComponent extends Component{
    private int capacityConsumption;
    private int memoryConsumption;

    protected SoftwareComponent(String name, String type) {
        super(name, type);
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getMemory() {
        return 0;
    }


    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
