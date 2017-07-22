package app.waste_disposal.models.garbages;

import app.waste_disposal.contracts.Waste;

public abstract class BaseGarbage implements Waste{
    private String name;
    private double volumePerKg;
    private double weight;

    protected BaseGarbage(String name, double weight, double volumePerKg) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return String.format("%.2f kg of %s successfully processed!", this.weight, this.name);
    }
}
