package SystemSplit.software;

public class LightSoftwareComponent extends SoftwareComponent{

    public LightSoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "lightSoftware");
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        capacityConsumption = capacityConsumption + (int)(capacityConsumption * 0.5);
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        memoryConsumption = memoryConsumption / 2;
        super.setMemoryConsumption(memoryConsumption);
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
