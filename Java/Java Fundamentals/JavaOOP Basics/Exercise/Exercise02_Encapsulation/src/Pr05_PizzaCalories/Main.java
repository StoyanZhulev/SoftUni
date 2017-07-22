package Pr05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstLine = reader.readLine();
            String secondLine = "";
            if(firstLine.startsWith("Dough")){
                String[] doughArgs = firstLine.split(" ");
                String flourType = doughArgs[1];
                String backingTechn = doughArgs[2];
                double weight = Double.parseDouble(doughArgs[3]);

                Dough dough = new Dough(flourType, backingTechn, weight);

                secondLine = reader.readLine();
                System.out.printf("%.2f%n", dough.getDoughCalories());
            }
            if("END".equals(secondLine)){
                return;
            }else if(secondLine.startsWith("Topping")){
                String[] toppingArgs = secondLine.split(" ");
                String toppingType = toppingArgs[1];
                double toppingWeight = Double.parseDouble(toppingArgs[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                System.out.printf("%.2f%n", topping.getToppingCalories());
                return;
            }

            String[] pizzaArgs = firstLine.split(" ");
            String pizzaName = pizzaArgs[1];
            int pizzaToppings = Integer.parseInt(pizzaArgs[2]);
            Pizza pizza = new Pizza(pizzaName, pizzaToppings);

            String[] doughArgs = reader.readLine().split(" ");
            String flourType = doughArgs[1];
            String backingTechn = doughArgs[2];
            double weight = Double.parseDouble(doughArgs[3]);


            Dough dough = new Dough(flourType, backingTechn, weight);
            pizza.setPizzaDough(dough);

            for (int i = 0; i < pizza.getNumberOfToppings(); i++) {
                String[] toppingArgs = reader.readLine().split(" ");
                String toppingType = toppingArgs[1];
                double toppingWeight = Double.parseDouble(toppingArgs[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }

            System.out.printf("%s - %.2f",pizza.getName(),pizza.getTotalCalories());

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
