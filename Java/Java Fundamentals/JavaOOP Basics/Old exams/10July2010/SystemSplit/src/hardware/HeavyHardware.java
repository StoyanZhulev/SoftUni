package hardware;

public class HeavyHardware extends Hardware{
    public HeavyHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
    }


    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        maximumCapacity = maximumCapacity * 2;
        super.setMaximumCapacity(maximumCapacity);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        maximumMemory = maximumMemory - (int)(maximumMemory  * 0.25);
        super.setMaximumMemory(maximumMemory);
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
