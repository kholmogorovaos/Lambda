import fruits.Apple;
import fruits.Fruit;
import vegetables.Cucumber;
import vegetables.Vegetable;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Vegetable cucumber = new Cucumber();
        Basket<Fruit> fruitBasket = new Basket<>();
        Basket<Vegetable> vegetableBasket = new Basket<>();

        fruitBasket.addItem(apple);
        vegetableBasket.addItem(cucumber);
    }
}
