package com.fruitbase.fruits;

import java.math.BigDecimal;
import java.io.Serializable;

public class Banana extends Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    public Banana() {
        super("Banana", 11.4, BigDecimal.valueOf(26.35),Freshness.OVERRIPED);
    }
}
