package Pr05_SpeedRacing;

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
            Car car = new Car(carArgs[0], Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));
            cars.putIfAbsent(carArgs[0], car);
        }

        String command = reader.readLine();

        while (!"End".equals(command)){
            String[] commandArgs = command.split(" ");
            String carName = commandArgs[1];
            double distance = Double.parseDouble(commandArgs[2]);
            if(cars.containsKey(carName)){
                try{
                    cars.get(carName).carTravell(distance);
                }catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
            }

            command = reader.readLine();
        }

        for (String car : cars.keySet()) {
            System.out.printf("%s %.2f %.0f%n", cars.get(car).getCarModel(), cars.get(car).getCarfuelAmount(), cars.get(car).getDistanceTravelled());
        }
    }
}
