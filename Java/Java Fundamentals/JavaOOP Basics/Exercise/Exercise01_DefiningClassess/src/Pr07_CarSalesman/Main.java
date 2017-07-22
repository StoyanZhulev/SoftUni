package Pr07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int engineLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < engineLines; i++) {
            String[] engineArgs = reader.readLine().split(" ");

            makeEngine(engineArgs, engines);
        }

        int carLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < carLines; i++) {
            String[] carArgs = reader.readLine().split(" ");

            Car car = makeCar(carArgs, cars, engines);

            System.out.println(car.getModel() + ":");
            System.out.printf("  %s:%n", car.getEngine().getModel());
            System.out.printf("    Power: %s%n", car.getEngine().getPower());
            System.out.printf("    Displacement: %s%n", car.getEngine().getDisplacement());
            System.out.printf("    Efficiency: %s%n", car.getEngine().getEfficiency());
            System.out.printf("  Weight: %s%n", car.getWeight());
            System.out.printf("  Color: %s%n", car.getColor());
        }

    }

    private static Car makeCar(String[] carArgs, LinkedHashMap<String, Car> cars, LinkedHashMap<String, Engine> engines) {
        String model = carArgs[0];
        String engineName = carArgs[1];
        Engine engine = engines.get(engineName);

        switch (carArgs.length) {
            case 2:
                return new Car(model, engine);

            case 3:
                try {
                    int weight = Integer.parseInt(carArgs[2]);
                    return new Car(model, engine, weight);

                } catch (NumberFormatException nfe) {
                    String color = carArgs[2];
                    return new Car(model, engine, color);
                }

            default:
                String weight = carArgs[2];
                String color = carArgs[3];
                return new Car(model, engine, weight, color);


        }
    }

    private static void makeEngine(String[] engineArgs, LinkedHashMap<String, Engine> engines) {
        String model = engineArgs[0];
        int power = Integer.parseInt(engineArgs[1]);
        switch (engineArgs.length) {
            case 2:
                Engine engine = new Engine(model, power);
                engines.putIfAbsent(engine.getModel(), engine);
                break;
            case 3:
                try {
                    int displacement = Integer.parseInt(engineArgs[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException ife) {
                    String efficiency = engineArgs[2];
                    engine = new Engine(model, power, efficiency);
                }
                engines.putIfAbsent(engine.getModel(), engine);
                break;
            case 4:
                String displacement = engineArgs[2];
                String efficiency = engineArgs[3];
                engine = new Engine(model, power, displacement, efficiency);
                engines.putIfAbsent(engine.getModel(), engine);
        }
    }

}
