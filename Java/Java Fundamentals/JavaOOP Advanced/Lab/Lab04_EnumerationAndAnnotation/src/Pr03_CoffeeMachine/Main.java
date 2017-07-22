package Pr03_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachinable machine = new CoffeeMachine();
        String command = reader.readLine();

        while (!"END".equals(command)){
            String[] cmdArgs = command.split(" ");
            if(cmdArgs.length == 1){
                machine.insertCoin(cmdArgs[0]);
            }else{
                machine.buyCoffee(cmdArgs[0], cmdArgs[1]);
            }

            command = reader.readLine();
        }

        for (Coffee coffee : machine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
