package needForSpeed.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;


    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.setHorsePower(horsePower);
        this.setSuspension(suspension);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void setHorsePower(int horsePower) {
        horsePower = horsePower + (horsePower * 50) / 100;
        super.setHorsePower(horsePower);
    }

    @Override
    public void setSuspension(int suspension) {
        suspension = suspension - (suspension * 25) / 100;
        super.setSuspension(suspension);
    }

    public void addAddOns(String addOns) {
        this.addOns.add(addOns);
    }

    @Override
    public String toString() {
        String o = super.toString();

        StringBuilder sb = new StringBuilder(o);

        sb.append("Add-ons: ");

        if(this.addOns.isEmpty()){
            sb.append("None");
        }else{
            for (String addOn : addOns) {
                sb.append(addOn).append(", ");
            }

            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();

    }
}
