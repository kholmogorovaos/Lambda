package com.fruitbase;

import com.fruitbase.fruits.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

public class FruitCatalogue implements Serializable {
    private static final long serialVersionUID = 1L;
    Fruit[] fruit = {new Apple(), new Banana(), new Orange(), new Pineapple()};

    FruitCatalogue() {
    }

    public Fruit findFruit(String fruitName) {
        for (Fruit f : fruit) {
            if (f.getName().equals(fruitName)) {
                return f;
            }
        }
        return null;
    }

    // Новый класс с помощью анонимного класса
    {
        Fruit[] newFruit = Arrays.copyOf(fruit, fruit.length + 2);
        newFruit[fruit.length] = new Fruit("Mango", 0.25, BigDecimal.valueOf(3.99), Freshness.FRESH) {
        };
        newFruit[fruit.length + 1] = new Fruit("Kiwi", 0.2, BigDecimal.valueOf(2.49), Freshness.OVERRIPED) {
        };
        fruit = newFruit;
    }

    //для проверки значений сериализации и десериализации
    @Override
    public String toString() {
        return "FruitCatalogue{" +
                "fruit=" + Arrays.toString(fruit) +
                '}';
    }
}



