package Pr04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();


        String[] personArgs = reader.readLine().split(";");
            for (String person : personArgs) {
                String[] nameAndMoney = person.split("=");
                String name = nameAndMoney[0];
                double money = Double.parseDouble(nameAndMoney[1]);

                try{
                    Person person1 = new Person(name, money);
                    people.putIfAbsent(person1.getName(), person1);
                }catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                    return;
                }
            }

            String[] productArgs = reader.readLine().split(";");
        for (String productArg : productArgs) {
            String[] nameAndCost = productArg.split("=");
            String name = nameAndCost[0];
            double cost = Double.parseDouble(nameAndCost[1]);

            try{
                Product product = new Product(name, cost);
                products.putIfAbsent(product.getName(), product);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        String command = reader.readLine();
        while (!"END".equals(command)){

            String[] commandArgs = command.split("\\s+");
            String personName = commandArgs[0];
            String productName = commandArgs[1];

            try{
                people.get(personName).buyProduct(products.get(productName));
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }

            command = reader.readLine();
        }




        if(people.size() > 0){
            for (Person person : people.values()) {
                if(person.getProducts().isEmpty()){
                    System.out.println(person.getName() + " - Nothing bought");
                }else{
                    System.out.print(person.getName() + " - ");
                    StringBuilder sb = new StringBuilder();
                    for (Product product : person.getProducts()) {
                        sb.append(product.getName()).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                    System.out.println(sb);

                }
            }
        }
    }
}
