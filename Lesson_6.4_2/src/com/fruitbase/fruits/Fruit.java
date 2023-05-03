package com.fruitbase.fruits;
import java.math.BigDecimal;
import java.util.Objects;
import java.io.Serializable;
abstract public class Fruit implements Serializable {
    private static final long serialVersionUID = 1L;
    protected double weight;
    protected BigDecimal price;
    protected String name;
    protected Freshness freshness;
    public Fruit(String name, double weight, BigDecimal price, Freshness freshness) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.freshness = freshness;
    }
    public double getWeight() {
        return weight;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public Freshness getFreshness() {
        return freshness;
    }
    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit that = (Fruit) o;
        if (freshness != that.freshness) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name)&&
                Objects.equals(price, fruit.price) &&
                Objects.equals(weight, fruit.weight)&&
                Objects.equals(freshness, fruit.freshness);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight, freshness);
    }
    public boolean isFresh() {
        if (freshness == Freshness.FRESH) {
            return true;
        }
        return false;
    }

    //для проверки значений сериализации и десериализации
    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", freshness=" + freshness +
                '}';
    }
}
