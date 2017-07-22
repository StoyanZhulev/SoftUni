package Ex04_SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr14_DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Double>>> army = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] dragonArgs = reader.readLine().split(" ");

            String type = dragonArgs[0];
            String name = dragonArgs[1];
            double damage = 0;
            if (!"null".equals(dragonArgs[2])) {
                damage = Double.parseDouble(dragonArgs[2]);
            } else {
                damage = 45;
            }
            double health = 0;
            if (!"null".equals(dragonArgs[3])) {
                health = Double.parseDouble(dragonArgs[3]);
            } else {
                health = 250;
            }
            double armor = 0;
            if (!"null".equals(dragonArgs[4])) {
                armor = Double.parseDouble(dragonArgs[4]);
            } else {
                armor = 10;
            }

            if (!army.containsKey(type)) {
                army.put(type, new TreeMap<>());
            }
            army.get(type).put(name, new ArrayList<>());
            army.get(type).get(name).add(damage);
            army.get(type).get(name).add(health);
            army.get(type).get(name).add(armor);
        }

        LinkedHashMap<String, ArrayList<Double>> typeAverageStats = new LinkedHashMap<>();

        for (String type : army.keySet()) {
            double averageDamage = 0.0;
            double averageHealth = 0.0;
            double averageArmor = 0.0;

            for (ArrayList<Double> stats : army.get(type).values()) {
                averageDamage += stats.get(0);
                averageHealth += stats.get(1);
                averageArmor += stats.get(2);
            }

            averageDamage /= army.get(type).size();
            averageHealth /= army.get(type).size();
            averageArmor /= army.get(type).size();

            ArrayList<Double> averageStats = new ArrayList<>();
            averageStats.add(averageDamage);
            averageStats.add(averageHealth);
            averageStats.add(averageArmor);

            typeAverageStats.put(type, averageStats);
        }

        for (String type : typeAverageStats.keySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, typeAverageStats.get(type).get(0), typeAverageStats.get(type).get(1), typeAverageStats.get(type).get(2));

            for (String dragon : army.get(type).keySet()) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", dragon, army.get(type).get(dragon).get(0), army.get(type).get(dragon).get(1), army.get(type).get(dragon).get(2));
            }
        }
    }
}
