package Pr08_PokemonTrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addBadges(String element) {
        boolean isFound = false;
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)){
                this.numberOfBadges++;
                isFound = true;
                break;
            }
        }

        if(!isFound){
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);
                pokemon.setHealth(pokemon.getHealth() - 10);
                if(pokemon.getHealth() <= 0){
                    pokemons.remove(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.getNumberOfBadges() + " " + this.pokemons.size();
    }
}
