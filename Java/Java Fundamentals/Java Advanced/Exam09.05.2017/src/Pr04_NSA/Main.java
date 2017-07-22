package Pr04_NSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> spies = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"quit".equals(line)){
            String[] lineArgs = line.split("\\s+->\\s+");
            String country = lineArgs[0];
            String spyName = lineArgs[1];
            int daysInService = Integer.parseInt(lineArgs[lineArgs.length - 1]);

            if(!spies.containsKey(country)){
                spies.put(country, new LinkedHashMap<>());
            }

            spies.get(country).put(spyName, daysInService);

            line = reader.readLine();
        }

        spies.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().keySet().size(), c1.getValue().keySet().size()))
                .forEach(c -> {
                    System.out.println("Country: " + c.getKey());
                    c.getValue().entrySet().stream()
                            .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                            .forEach(s -> System.out.printf("**%s : %d%n", s.getKey(), s.getValue()));
                });
    }
}
