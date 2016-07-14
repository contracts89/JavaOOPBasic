package problem4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * Created by Radoslav on 11.7.2016 г..
 */
public class Person {
    private String name;
    private int money;
    private LinkedList<Product> bagOfProducts;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void addProductsToBag(Product product){
        if(product.getCost() <= this.getMoney()){
            this.bagOfProducts.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            System.out.println(this.getName() + " bought " + product.toString());
        }else {
            System.out.println(this.getName() + " can't afford " + product.toString());
        }
    }

    @Override
    public String toString() {
        if(this.bagOfProducts.isEmpty()){
            return this.getName() + " - Nothing bought";
        }
        StringJoiner sj = new StringJoiner(", ");
        for (Product product : bagOfProducts) {
            sj.add(product.toString());
        }
        return this.getName() + " - " + sj;
    }
}
