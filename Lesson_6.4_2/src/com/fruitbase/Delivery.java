package com.fruitbase;

import com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.List;

public interface Delivery {
    double getTotalWeight();

    BigDecimal getTotalPrice();

    double getRemovedWeight();

    BigDecimal getRemovedPrice();

    void addFruit(Fruit fruit);

    List<Fruit> getFruits();

    void removeFruits(List<Fruit> selectedFruits);
}
