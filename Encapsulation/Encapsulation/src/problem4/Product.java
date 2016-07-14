package problem4;

import java.util.ArrayList;

/**
 * Created by Radoslav on 11.7.2016 г..
 */
public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()||name.trim().length()==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
