package Pr08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String line = reader.readLine();

        while(!"Tournament".equals(line)){
            String[] lineArgs = line.split(" ");
            String trainerName = lineArgs[0];
            String pokemonName = lineArgs[1];
            String pokemonElement = lineArgs[2];
            int pokemonHealth = Integer.parseInt(lineArgs[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if(!trainers.containsKey(trainerName)){
                Trainer trainer = new Trainer(trainerName);
                trainer.addPokemon(pokemon);
                trainers.put(trainerName, trainer);
            }else{
                trainers.get(trainerName).addPokemon(pokemon);
            }

            line = reader.readLine();
        }

        String element = reader.readLine();
        while (!"End".equals(element)){
            for (Trainer trainer : trainers.values()) {
                trainer.addBadges(element);
            }

            element = reader.readLine();
        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumberOfBadges(), b1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.println(t.getValue()));
    }
}
