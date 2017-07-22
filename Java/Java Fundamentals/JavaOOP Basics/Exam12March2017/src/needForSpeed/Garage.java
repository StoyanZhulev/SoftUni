package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;

import java.util.HashMap;

public class Garage {
    private HashMap<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }


    public HashMap<Integer, Car> getParkedCars() {
        return parkedCars;
    }

    public void addCar(int id, Car car){
        this.parkedCars.put(id, car);
    }

    public void removeCar(int id){
        this.parkedCars.remove(id);
    }

    public void tuneCars(int tuuneIndex, String tuneAddon){
        for (Car car : parkedCars.values()) {
            car.upgradeHorsePower(car.getHorsePower() + tuuneIndex);
            car.upgradeSuspension(car.getSuspension() + tuuneIndex / 2);
            if(car instanceof PerformanceCar){
                ((PerformanceCar) car).addAddOns(tuneAddon);
            }else if (car instanceof ShowCar){
                ((ShowCar) car).addStars(tuuneIndex);
            }
        }
    }
}
