package Ex04_SetsAndMaps;

import java.util.*;

public class Pr10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Long> countryPopulations = new TreeMap<>();
        TreeMap<String, TreeMap<String, Long>> cityPopulations = new TreeMap<>();


        while (true){
            String input = scanner.nextLine();

            if("report".equals(input)){
                break;
            }

            String[] lineArgs = input.split("\\|");
            String city = lineArgs[0];
            String country = lineArgs[1];
            long population = Long.parseLong(lineArgs[2]);

            if(!cityPopulations.containsKey(country)){
                cityPopulations.put(country, new TreeMap<>());
                cityPopulations.get(country).put(city, population);
                countryPopulations.put(country, population);
            }else{
                if(!cityPopulations.get(country).containsKey(city)){
                    cityPopulations.get(country).put(city, population);
                    countryPopulations.put(country, (countryPopulations.get(country) + population));
                }else{
                    cityPopulations.get(country).put(city, (cityPopulations.get(country).get(city) + population));
                    countryPopulations.put(country, (countryPopulations.get(country) + population));
                }
            }
        }

        cityPopulations.entrySet().stream()
                .sorted((c1,c2)-> countryPopulations.get(c2.getKey()).compareTo(countryPopulations.get(c1.getKey())))
                .forEach(country ->{
                    System.out.printf("%s (total population: %d)\n",country.getKey(),countryPopulations.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city ->{
                        System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                    });
                });

    }
}
