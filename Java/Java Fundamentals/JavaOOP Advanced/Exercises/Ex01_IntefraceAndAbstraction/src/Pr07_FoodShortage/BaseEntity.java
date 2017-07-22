package Pr07_FoodShortage;

public abstract class BaseEntity implements Personalizable, Buyer {
    private String name;
    private String birthDay;

    protected BaseEntity(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
