package needForSpeed.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    public int getOverallPerformance(){

        return (this.horsePower / this.acceleration) + (this.suspension + this.durability);
    }

    public int getEnginePerformance(){
        return (this.horsePower / this.acceleration);
    }

    public int getSuspensionPerformance(){
        return this.suspension + this.durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void upgradeSuspension(int suspension){
        this.suspension = suspension;
    }

    public void upgradeHorsePower(int horsePower){
        this.horsePower = horsePower;
    }


    @Override
    public String toString() {
        String sb = this.brand + " " + this.getModel() + " " + this.yearOfProduction +
                "\n" +
                this.horsePower + " HP, 100 m/h in " + this.acceleration + " s" +
                "\n" +
                this.suspension + " Suspension force, " + this.durability + " Durability" +
                "\n";

        return sb;
    }
}
