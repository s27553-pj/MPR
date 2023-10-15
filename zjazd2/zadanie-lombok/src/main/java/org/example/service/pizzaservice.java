package org.example.service;

import org.example.exception.PizzaNotFoundException;
import org.example.model.Order;
import org.example.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class pizzaservice {
    private List<Order> orderList = new ArrayList<>();
    private List<Pizza> pizzaList;
    public pizzaservice(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Order makeOrder(List<Pizza> orderedPizzas)
    {
      //oczekujemy tutaj zwrocenia informacji o zamowieniu
      // numer zamowienia pizza cena
      //sprawdzamy czy zamowione  pizze sa dostepne
        //tworzymy obiekt order
        //numer zamowienia bedzie bazowal na rozmiarze orderlist
        //cena to suma cen wszystkich zamowionych pizz
        //dodajemy order do orderlist
        //zwracamy order
    if(getAvailablePizzas().containsAll(orderedPizzas)){
        double sum = orderedPizzas.stream()
                .map((Pizza::getPrice))
                .reduce(0D,(current,price) -> current+price);
        Order order = new Order(orderList.size(),orderedPizzas,sum);
    orderList.add(order);
    return order;
    }else {
        throw new PizzaNotFoundException();
    }
    }
    public List<Pizza> getAvailablePizzas(){
        //oczekujemy listy dostepbych pizz i ich cen
return pizzaList.stream()
        //zwrocenie listy dostepbych pizz(filtrowanie po is available)
        .filter(Pizza::isAvailable)
        .collect(Collectors.toList());
    }

}
