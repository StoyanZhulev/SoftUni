package Pr01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        Car car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));

        String[] truckArgs = reader.readLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]));

        int comandsNum = Integer.parseInt(reader.readLine());

        for (int i = 0; i < comandsNum; i++) {
            String[] command = reader.readLine().split(" ");
            switch (command[1].toLowerCase()){
                case "car":
                    execCarCommand(command, car);
                    break;
                case "truck":
                    execTruckCommand(command, truck);
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelCapacity());
        System.out.printf("Truck: %.2f%n", truck.getFuelCapacity());
    }

    private static void execCommand(String[] commands, Vehicle vehicle){
        switch (commands[0].toLowerCase()){
            case "drive":
                vehicle.driveDistance(Double.parseDouble(commands[2]));
                break;
            case "refuel":
                vehicle.refuelCapacity(Double.parseDouble(commands[2]));
                break;

        }
    }

    private static void execTruckCommand(String[] command, Truck truck) {
        execCommand(command, truck);
    }

    private static void execCarCommand(String[] command, Car car) {
        execCommand(command, car);
    }
}
