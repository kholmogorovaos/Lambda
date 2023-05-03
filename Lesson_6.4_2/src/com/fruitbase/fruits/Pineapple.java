package com.fruitbase.fruits;

import java.math.BigDecimal;
import java.io.Serializable;

public class Pineapple extends Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    public Pineapple() {
        super("Pineapple", 3, BigDecimal.valueOf(102.45),Freshness.SPOILED);
    }
}
