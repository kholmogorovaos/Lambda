package com.fruitbase.fruits;

import java.math.BigDecimal;
import java.io.Serializable;

public class Orange extends Fruit implements Serializable {
    private static final long serialVersionUID = 1L;

    public Orange() {
        super("Orange", 15.5, BigDecimal.valueOf(78.65),Freshness.FRESH);
    }

}
