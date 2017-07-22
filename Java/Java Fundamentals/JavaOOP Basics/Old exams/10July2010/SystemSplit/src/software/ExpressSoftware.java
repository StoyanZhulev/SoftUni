package software;

public class ExpressSoftware extends Software {

    public ExpressSoftware(String name,String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        super.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        memoryConsumption = memoryConsumption * 2;
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
