package SystemSplit.hardware;

public class PowerHardwareComponent extends HardwareComponent{

    public PowerHardwareComponent(String name, int maximumCapacity, int maximumMemory) {
        super(name, "powerHardware");
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        maximumCapacity = maximumCapacity - (int)(maximumCapacity*0.75);
        super.setMaximumCapacity(maximumCapacity);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        maximumMemory = maximumMemory + (int)(maximumMemory * 0.75);
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
