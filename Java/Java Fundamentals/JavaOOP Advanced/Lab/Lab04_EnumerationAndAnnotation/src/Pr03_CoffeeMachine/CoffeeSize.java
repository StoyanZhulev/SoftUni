package Pr03_CoffeeMachine;

public enum CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getMl(){
        return this.dosage;
    }

    public int getPrice(){
         return this.price;
    }
}
