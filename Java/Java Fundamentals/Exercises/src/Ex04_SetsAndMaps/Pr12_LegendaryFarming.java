package Ex04_SetsAndMaps;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;

public class Pr12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> legendary = new TreeMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        legendary.put("shards", 0);
        legendary.put("fragments", 0);
        legendary.put("motes", 0);

        boolean isLegendaryFound = false;

        while(isLegendaryFound == false){

            if(isLegendaryFound){
                break;
            }

            String[] line = scanner.nextLine().split(" ");
            for (int i = 0; i < line.length; i+=2) {
                int quantity = Integer.parseInt(line[i]);
                String product = line[i + 1].toLowerCase();

                if (legendary.containsKey(product)){
                        legendary.put(product, legendary.get(product) + quantity);

                }else{
                    if(!junk.containsKey(product)){
                        junk.put(product, quantity);
                    }else{
                        junk.put(product, junk.get(product) + quantity);
                    }
                }
                if(legendary.get("shards") >= 250){
                    legendary.put("shards", legendary.get("shards") - 250);
                    System.out.println("Shadowmourne obtained!");
                    isLegendaryFound = true;
                    break;
                }else if(legendary.get("fragments") >= 250){
                    legendary.put("fragments", legendary.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    isLegendaryFound = true;
                    break;
                }else if(legendary.get("motes") >= 250){
                    legendary.put("motes", legendary.get("motes") - 250);
                    System.out.println("Dragonwrath obtained!");
                    isLegendaryFound = true;
                    break;
                }
            }
        }

        legendary.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .forEach(product -> {
                    System.out.printf("%s: %d%n", product.getKey(), product.getValue());
                });

        for (String junkPr : junk.keySet()) {
            System.out.printf("%s: %d%n", junkPr, junk.get(junkPr));
        }

    }
}
