package com.customers;

import com.fruitbase.Delivery;
import com.fruitbase.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FreshCustomer extends Customer {
    public FreshCustomer(String name) {
        super(name);
    }

    @Override
    public List<Fruit> takeFruits(Delivery delivery) {
        List<Fruit> freshFruits = new ArrayList<>();
        for (Fruit fruit : delivery.getFruits()) {
            if (fruit.isFresh()) {
                freshFruits.add(fruit);
            }
        }
        purchases.addAll(freshFruits);
        return purchases;
    }
}
