package Ex04_SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pr12_Farming_Lab {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> materials = new LinkedHashMap<String, Integer>(){
            {
                put("fragments", 0);
                put("motes", 0);
                put("shards", 0);
            }
        };

        Map<String, Integer> junk = new TreeMap<>();


        boolean mustBreack = false;
        while(!mustBreack){
            String[] input = reader.readLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i+=2) {
                String material = input[i + 1];
                int quantity = Integer.parseInt(input[i + 1]);

                if(materials.containsKey(material)){
                    materials.put(material, materials.get(material) + quantity);
                   if(materials.get(material) >= 250){
                       materials.put(material, materials.get(material) - 250);
                       mustBreack = true;
                       switch (material){
                           case "shards":
                               System.out.println("Shadowmmoure obtained!");
                               break;
                           case "fragments":
                               System.out.println("Valanyr obtained!");
                               break;
                           case "motes":
                               System.out.println("Dragonwrath obtained!");
                               break;
                       }
                       break;
                   }
                }else{
                    if(!junk.containsKey(material)){
                        junk.put(material, 0);
                    }

                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }

        materials.entrySet()
                .stream()
                .sorted((v1, v2) -> {
                    if (v2.getValue().compareTo(v1.getValue()) == 0){
                        return v1.getKey().compareTo(v2.getKey());
                    }
                    return v2.getValue().compareTo(v1.getValue());
                    //v2.getValue().compareTo(v1.getValue()))
                })
                .forEach(pair -> System.out.printf("%s: %d%n", pair.getKey(), pair.getValue()));

        junk.entrySet().forEach(pair -> System.out.printf(String.format("%s: %d", pair.getKey(), pair.getValue()) + System.lineSeparator()));
    }

}
