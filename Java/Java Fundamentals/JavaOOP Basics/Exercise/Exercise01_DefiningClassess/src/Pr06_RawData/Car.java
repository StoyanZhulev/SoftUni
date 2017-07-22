package Pr06_RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo){
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>();
    }


    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public void addTires(Tire tire){
        this.tires.add(tire);
    }

    public boolean hasSearchedPressure(){
        for (Tire tire : this.tires) {
            if(tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }
}
