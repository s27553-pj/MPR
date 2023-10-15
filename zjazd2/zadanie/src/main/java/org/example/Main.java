package org.example;

import org.example.model.Order;
import org.example.model.Pizza;
import org.example.service.pizzaservice;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    Pizza pizza1 = new Pizza("A",25,true);
    Pizza pizza2 = new Pizza("B",25,true);
    Pizza pizza3 = new Pizza("C",25,true);
    Pizza pizza4 = new Pizza("D",25,false);
    Pizza pizza5 = new Pizza("E",25,true);
        pizzaservice pizzaservice = new pizzaservice(List.of(pizza1,pizza2,pizza3,pizza4,pizza5));
        System.out.println(pizzaservice.getAvailablePizzas());



    }
}