package definigClasses.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Radoslav on 2.7.2016 г..
 */

class Trainer {
    String name;
    int numberOfBadges;
    ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void checkPokemons() {
        ArrayList<Pokemon> pokemons = this.pokemons;
        ArrayList<Pokemon> newPok = pokemons.stream().filter(p -> p.health > 0).collect(Collectors.toCollection(ArrayList::new));
        this.pokemons = newPok;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}

class Pokemon {
    String name;
    String element;
    int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}

public class PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        while (true) {
            String[] tokens = sc.readLine().split("\\s+");
            if (tokens[0].equals("Tournament")) {
                break;
            }
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            trainers.get(trainerName).addPokemon(pokemon);
        }
        while (true) {
            String line = sc.readLine();
            if (line.equals("End")) {
                break;
            }

            switch (line) {
                case "Fire":
                    tournamentPokemons(trainers, line);
                    break;
                case "Water":
                    tournamentPokemons(trainers, line);
                    break;
                case "Electricity":
                    tournamentPokemons(trainers, line);
                    break;
            }
        }

        trainers.entrySet().stream().sorted((t1, t2) -> Integer.compare(t2.getValue().numberOfBadges, t1.getValue().numberOfBadges)).forEach(trainer -> {
            System.out.println(trainer.getValue().toString());
        });
    }

    private static void tournamentPokemons(LinkedHashMap<String, Trainer> trainers, String line) {
        for (Trainer trainer : trainers.values()) {
            boolean hasElement = false;
            for (Pokemon pokemon : trainer.pokemons) {
                if (pokemon.element.equals(line)) {
                    hasElement = true;
                }
            }
            if (hasElement) {
                trainer.numberOfBadges += 1;
            } else {
                for (Pokemon pokemon : trainer.pokemons) {
                    pokemon.health -= 10;
                }
            }
            trainer.checkPokemons();
        }
    }
}
