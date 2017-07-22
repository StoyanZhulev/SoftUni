package needForSpeed;

import needForSpeed.cars.Car;
import needForSpeed.cars.PerformanceCar;
import needForSpeed.cars.ShowCar;
import needForSpeed.races.*;

import java.util.HashMap;

public class CarManager {
    private HashMap<Integer, Car> cars;
    private HashMap<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new HashMap<>();
        this.races = new HashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){
        switch (type){
            case "Performance":
                PerformanceCar perfCar = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                this.cars.put(id, perfCar);
                break;
            case "Show":
                ShowCar showCar = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                this.cars.put(id, showCar);
                break;

        }
    }

    public String check(int id){
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool){
        switch (type){
            case "Casual":
                CasualRace casRace = new CasualRace(length, route, prizePool);
                this.races.put(id, casRace);
                break;
            case "Drag":
                DragRace dragRace = new DragRace(length, route, prizePool);
                this.races.put(id, dragRace);
                break;
            case "Drift":
                DriftRace drRace = new DriftRace(length, route, prizePool);
                this.races.put(id, drRace);
                break;
        }
    }

    public void open(int id, String type, int length, String route, int prizePool, int goldTime){
        switch (type){
            case "TimeLimit":
                TimeLimitRace tRace = new TimeLimitRace(length, route, prizePool, goldTime);
                this.races.put(id, tRace);
                break;
            case "Circuit":
                CircuitRace cRace = new CircuitRace(length, route, prizePool, goldTime);
                this.races.put(id, cRace);
                break;

        }
    }

    public void participate(int carId, int raceId){
        if(!this.garage.getParkedCars().containsKey(carId)){
            if(this.races.containsKey(raceId)){
                if(this.races.get(raceId) instanceof TimeLimitRace){
                    if(this.races.get(raceId).getParticipants().isEmpty()){
                        this.races.get(raceId).addParticipant(this.cars.get(carId));
                    }
                }else{
                    this.races.get(raceId).addParticipant(this.cars.get(carId));
                }
            }
        }
    }

    public String start(int id){
        if(this.races.containsKey(id)){
            String out = this.races.get(id).toString();
            if(!"Cannot start the race with zero participants.".equals(out)){
                this.races.remove(id);
            }
            return out;
        }
        return "";
    }

    public void park(int id){
        boolean isParticipant = false;
        for (Race race : races.values()) {
            if(race.getParticipants().contains(this.cars.get(id))){
                isParticipant = true;
                break;
            }
        }
        if(!isParticipant){
            this.garage.addCar(id, cars.get(id));
        }
    }

    public void unpark(int id){
        this.garage.removeCar(id);
    }

    public void tune(int tuneIndex, String addOn){
        if(!this.garage.getParkedCars().isEmpty()){
            this.garage.tuneCars(tuneIndex, addOn);
        }
    }
}
