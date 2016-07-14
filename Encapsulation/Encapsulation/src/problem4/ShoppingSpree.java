package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Radoslav on 11.7.2016 г..
 */
public class ShoppingSpree {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Person> people = new LinkedList<>();
        ArrayList<Product> products = new ArrayList<>();
        String[] firstLine = sc.readLine().split(";");
        try {
            for (int i = 0; i < firstLine.length; i++) {
                String[] tokens = firstLine[i].split("=");
                String name = tokens[0];
                int money = Integer.parseInt(tokens[1]);
                Person person = new Person(name, money);
                people.add(person);
            }

            String[] secondLine = sc.readLine().split(";");
            for (int i = 0; i < secondLine.length; i++) {
                String[] tokens = secondLine[i].split("=");
                String name = tokens[0];
                int cost = Integer.parseInt(tokens[1]);
                Product product = new Product(name, cost);
                products.add(product);
            }

            while (true) {
                String[] line = sc.readLine().split("\\s+");
                if (line[0].equals("END")) {
                    break;
                }
                String name = line[0];
                String productName = line[1];
                for (Person person : people) {
                    if (person.getName().equals(name)) {
                        for (Product product : products) {
                            if (product.getName().equals(productName)) {
                                person.addProductsToBag(product);
                            }
                        }
                    }
                }
            }

            for (Person person : people) {
                System.out.println(person);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
