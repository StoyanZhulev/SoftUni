package SystemSplit.software;

public class ExpressSoftwareComponent extends SoftwareComponent{

    public ExpressSoftwareComponent(String name,int capacityConsumption, int memoryConsumption) {
        super(name, "expressSoftware");
        super.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        memoryConsumption = memoryConsumption * 2;
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
