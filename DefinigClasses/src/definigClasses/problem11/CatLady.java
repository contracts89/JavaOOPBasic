package definigClasses.problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
abstract class Cat{
    String name;
    String catSpecific;

    public Cat(String name, String catSpecific) {
        this.name = name;
        this.catSpecific = catSpecific;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.catSpecific);
    }
}

class Siamese extends Cat{

    public Siamese(String name, String catSpecific) {
        super(name, catSpecific);
    }
}

class StreetExtraordinaire extends Cat{

    public StreetExtraordinaire(String name, String catSpecific) {
        super(name, catSpecific);
    }
}

class Cymric extends Cat{

    public Cymric(String name, String catSpecific) {
        super(name, catSpecific);
    }
}

public class CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, ArrayList<Cat>> cats = new TreeMap<>();
        while (true){
            String[] tokens = sc.readLine().split("\\s+");
            if(tokens[0].equals("End")){
                break;
            }

            switch (tokens[0]){
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(tokens[1], tokens[2]);
                    if(!cats.containsKey(tokens[1])){
                        cats.put(tokens[1], new ArrayList<>());
                    }
                    cats.get(tokens[1]).add(streetExtraordinaire);
                    break;
                case "Siamese":
                    Siamese siamese = new Siamese(tokens[1], tokens[2]);
                    if(!cats.containsKey(tokens[1])){
                        cats.put(tokens[1], new ArrayList<>());
                    }
                    cats.get(tokens[1]).add(siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(tokens[1], tokens[2]);
                    if(!cats.containsKey(tokens[1])){
                        cats.put(tokens[1], new ArrayList<>());
                    }
                    cats.get(tokens[1]).add(cymric);
                    break;
            }
        }

        String name = sc.readLine();

        for (Map.Entry<String, ArrayList<Cat>> stringArrayListEntry : cats.entrySet()) {
            for (Cat cat : stringArrayListEntry.getValue()) {
                if(cat.name.equals(name)){
                    System.out.print(cat.getClass().getSimpleName() + " ");
                    System.out.println(cat.toString());
                }
            }
        }
    }
}
