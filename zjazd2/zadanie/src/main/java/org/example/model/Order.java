package org.example.model;

import java.util.List;

public class Order {
    private int number;
    private List<Pizza> orderedPizzas;
    private double price;

    public Order(int number, List<Pizza> orderedPizzas, double price) {
        this.number = number;
        this.orderedPizzas = orderedPizzas;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public List<Pizza> getOrderedPizzas() {
        return orderedPizzas;
    }

    public double getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrderedPizzas(List<Pizza> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
