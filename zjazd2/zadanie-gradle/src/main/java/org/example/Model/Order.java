package org.example.Model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString


public class Order {
    private int number;
    private List<Pizza> orderedPizzas;
    private double price;
}

