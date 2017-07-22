package Lab04_SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pr01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new HashSet<>();

        while(true){
            String input = scanner.nextLine();
            if("END".equals(input)){
                break;
            }else{
                String[] carNumber = input.split(", ");

                if(carNumber[0].equals("IN")){
                    cars.add(carNumber[1]);
                }else{
                    cars.remove(carNumber[1]);
                }
            }
        }

        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : cars) {
                System.out.println(car);
            }
        }

    }
}
