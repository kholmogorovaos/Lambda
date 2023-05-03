package com.customers;

import com.fruitbase.Delivery;
import com.fruitbase.fruits.*;

import java.util.ArrayList;
import java.util.List;

abstract public class Customer {
    protected List<Fruit> purchases;
    protected String name;

    public Customer(String name) {
        this.purchases = new ArrayList<>();
        this.name = name;
    }

    public abstract List<Fruit> takeFruits(Delivery delivery);

    public void printPurchases() {
        if (purchases.isEmpty()) {
            System.out.println(name + " ещё ничего не купил.");
        } else {
            System.out.println(name + " купил:");
            for (Fruit fruit : purchases) {
                System.out.println(fruit.getName());
            }
            System.out.println();
        }
    }
}

