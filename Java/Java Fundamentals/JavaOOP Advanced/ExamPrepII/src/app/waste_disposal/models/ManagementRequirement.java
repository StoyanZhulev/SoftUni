package app.waste_disposal.models;

public class ManagementRequirement {
    public static final String MANAGEMENT_REQUIREMENT_CHANGED = "Management requirement changed!";
    private double requiredEnergy;
    private double requiredCapital;
    private String deniedType;


    public ManagementRequirement() {
        this.requiredEnergy = Double.MIN_VALUE;
        this.requiredCapital = Double.MIN_VALUE;
        this.deniedType = "None";
    }

    public ManagementRequirement(double requiredEnergy, double requiredCapital, String deniedType) {
        this.requiredEnergy = requiredEnergy;
        this.requiredCapital = requiredCapital;
        this.deniedType = deniedType;
    }

    public double getRequiredEnergy() {
        return this.requiredEnergy;
    }

    public double getRequiredCapital() {
        return this.requiredCapital;
    }

    public String getDeniedType() {
        return this.deniedType;
    }

    @Override
    public String toString() {
        return MANAGEMENT_REQUIREMENT_CHANGED;
    }
}
