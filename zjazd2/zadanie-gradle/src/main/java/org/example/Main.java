package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.Order;
import org.example.Model.Pizza;
import org.example.service.pizzaservice;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Pizza pizza1 = new Pizza("A",25,true);
        Pizza pizza2 = new Pizza("B",25,true);
        Pizza pizza3 = new Pizza("C",25,true);
        Pizza pizza4 = new Pizza("D",25,false);
        Pizza pizza5 = new Pizza("E",25,true);
        pizzaservice pizzaservice = new pizzaservice(List.of(pizza1,pizza2,pizza3,pizza4,pizza5));
        logger.info(pizzaservice.getAvailablePizzas());
        Order order1 = pizzaservice.makeOrder(List.of(pizza1));
        logger.info(order1);
        Order order2 = pizzaservice.makeOrder(List.of(pizza1,pizza2));
        logger.info(order2);
        try {
            Order order3 = pizzaservice.makeOrder(List.of(pizza3, pizza4));
        } catch (Exception ex) {
            logger.error("Taka pizza nie istnieje", ex);
        }


    }
}