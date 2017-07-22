package Pr02_VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        String[] truckArgs = reader.readLine().split(" ");
        String[] busArgs = reader.readLine().split(" ");

        try{
            Car car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]), Double.parseDouble(carArgs[3]));
            Truck truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]), Double.parseDouble(truckArgs[3]));
            Bus bus = new Bus(Double.parseDouble(busArgs[1]), Double.parseDouble(busArgs[2]), Double.parseDouble(busArgs[3]));

            int n = Integer.parseInt(reader.readLine());

                for (int i = 0; i < n; i++) {
                    String[] command = reader.readLine().split(" ");
                    switch (command[1].toLowerCase()){
                        case "car":
                            execCarCommand(command, car);
                            break;
                        case "truck":
                            execTruckCommand(command, truck);
                            break;
                        case "bus":
                            execBusCommand(command, bus);
                            break;
                    }
                }

            System.out.printf("Car: %.2f%n", car.getFuelCapacity());
            System.out.printf("Truck: %.2f%n", truck.getFuelCapacity());
            System.out.printf("Bus: %.2f%n", bus.getFuelCapacity());
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


    }

    private static void execCommand(String[] command, Vehicle vehicle){
        try{

            switch (command[0].toLowerCase()){
                case "drive":
//                    if(vehicle instanceof Bus){
//                        ((Bus) vehicle).setCurrentConsumption(command[0]);
//                    }
                    ((Bus) vehicle).setCurrentConsumption(command[0]);

                    vehicle.driveDistance(Double.parseDouble(command[2]));
                    break;
                case "refuel":
                    vehicle.refuelCapacity(Double.parseDouble(command[2]));
                    break;
                case "driveempty":
//                    if(vehicle instanceof Bus){
//                        ((Bus) vehicle).setCurrentConsumption(command[0]);
//                    }
                    ((Bus) vehicle).setCurrentConsumption(command[0]);
                    vehicle.driveDistance(Double.parseDouble(command[2]));
            }
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void execBusCommand(String[] command, Bus bus) {
        execCommand(command, bus);
    }

    private static void execTruckCommand(String[] command, Truck truck) {
        execCommand(command, truck);
    }

    private static void execCarCommand(String[] command, Car car) {
        execCommand(command, car);
    }
}
