package com.fruitbase.fruits;

import java.math.BigDecimal;
import java.io.Serializable;

public class Apple extends Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    public Apple() {
        super("Apple", 6, BigDecimal.valueOf(80),Freshness.FRESH);
    }
}
