package Pr06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] carArgs = reader.readLine().split(" ");

            String model = carArgs[0];
            int engineSpeed = Integer.parseInt(carArgs[1]);
            int enginePower = Integer.parseInt(carArgs[2]);
            int cargoWeight = Integer.parseInt(carArgs[3]);
            String cargoType = carArgs[4];
            double tire1Pressure = Double.parseDouble(carArgs[5]);
            int tire1Age = Integer.parseInt(carArgs[6]);
            double tire2Pressure = Double.parseDouble(carArgs[7]);
            int tire2Age = Integer.parseInt(carArgs[8]);
            double tire3Pressure = Double.parseDouble(carArgs[9]);
            int tire3Age = Integer.parseInt(carArgs[10]);
            double tire4Pressure = Double.parseDouble(carArgs[11]);
            int tire4Age = Integer.parseInt(carArgs[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);

            Car car = new Car(model, engine, cargo);
            car.addTires(tire1);
            car.addTires(tire2);
            car.addTires(tire3);
            car.addTires(tire4);

            cars.putIfAbsent(car.getModel(), car);
        }

        String cargoType = reader.readLine();

        switch (cargoType){
            case "fragile":
                cars.entrySet().stream()
                        .filter(c -> c.getValue().getCargo().getType().equals("fragile"))
                        .filter(c -> c.getValue().hasSearchedPressure())
                        .forEach(c -> System.out.println(c.getValue().getModel()));
                break;
            case "flamable":
                cars.entrySet().stream()
                        .filter(c -> c.getValue().getCargo().getType().equals("flamable"))
                        .filter(c -> c.getValue().getEngine().getPower() > 250)
                        .forEach(c -> System.out.println(c.getValue().getModel()));
                break;

        }
    }
}
