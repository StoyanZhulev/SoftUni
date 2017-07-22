package Pr01_SplinterTrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        double fuelPerKm = 25.0;
        double fielPerKmHeavyWind = 25*1.5;
        double fuelIncreasement = 0.05;

        double distance = Double.parseDouble(reader.readLine());
        double tankCapacity = Double.parseDouble(reader.readLine());
        double heavyWindMiles = Double.parseDouble(reader.readLine());

        double distanceNonHeavy = distance - heavyWindMiles;

        double nonHeavyConsumption = distanceNonHeavy * fuelPerKm;
        double heavyConsumption = heavyWindMiles * fielPerKmHeavyWind;

        double fuelConsump = nonHeavyConsumption + heavyConsumption;
        double totalCoonsumption = fuelConsump + (fuelConsump * fuelIncreasement);


        double remainingFuel = tankCapacity - totalCoonsumption;

        System.out.printf("Fuel needed: %.2fL%n", totalCoonsumption);
        if(remainingFuel >= 0){
            System.out.printf("Enough with %.2fL to spare!", remainingFuel);
        }else{
            System.out.printf("We need %.2fL more fuel.", Math.abs(remainingFuel));
        }
    }
}
