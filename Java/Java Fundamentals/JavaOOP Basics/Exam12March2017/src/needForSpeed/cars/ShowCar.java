package needForSpeed.cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void addStars(int stars){
        this.stars += stars;
    }

    @Override
    public String toString() {
        String o = super.toString();

        String out = o + this.stars + " *";

        return out;
    }
}
