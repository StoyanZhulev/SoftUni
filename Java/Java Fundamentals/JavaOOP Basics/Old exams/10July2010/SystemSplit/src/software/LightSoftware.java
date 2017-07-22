package software;

public class LightSoftware extends Software{

    public LightSoftware(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
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
    public String getName() {
        return super.getName();
    }

    @Override
    public String getType() {
        return super.getType();
    }
}
