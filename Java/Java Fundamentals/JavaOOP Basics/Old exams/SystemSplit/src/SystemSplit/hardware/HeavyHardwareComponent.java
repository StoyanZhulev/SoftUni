package SystemSplit.hardware;

public class HeavyHardwareComponent extends HardwareComponent{

    public HeavyHardwareComponent(String name,int maximumCapacity, int maximumMemory) {
        super(name, "heavyHardware");
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
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getMemory() {
        return 0;
    }
}
