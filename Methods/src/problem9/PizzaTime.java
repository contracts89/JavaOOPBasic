package problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Radoslav on 7.7.2016 г..
 */

class Pizza {
    private String name;
    private int group;

    public Pizza(String name, int group) {
        this.setName(name);
        this.setGroup(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

public class PizzaTime {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split("\\s+");
        HashMap<Integer, ArrayList<Pizza>> pizzas = new HashMap();
        Pattern pattern = Pattern.compile("(\\d+)(\\w+)");

        for (int i = 0; i < line.length; i++) {
            Matcher matcher = pattern.matcher(line[i]);
            int group = 0;
            String pizzaName = "";
            while (matcher.find()) {
                group = Integer.parseInt(matcher.group(1));
                pizzaName = matcher.group(2);
            }
            Pizza pizza = new Pizza(pizzaName, group);
            if (!pizzas.containsKey(group)) {
                pizzas.put(group, new ArrayList<>());
            }
            pizzas.get(group).add(pizza);
        }


        for (Map.Entry<Integer, ArrayList<Pizza>> integerArrayListEntry : pizzas.entrySet()) {
            StringJoiner sj = new StringJoiner(", ");
            System.out.printf("%d - ", integerArrayListEntry.getKey());
            for (Pizza pizza : integerArrayListEntry.getValue()) {
                sj.add(pizza.toString());
            }
            System.out.println(sj);
        }
    }
}
