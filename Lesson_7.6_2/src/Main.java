import fruits.Apple;
import fruits.Banana;
import fruits.Fruit;
import vegetables.Cucumber;
import vegetables.Tomato;
import vegetables.Vegetable;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable cucumber = new Cucumber();
        Vegetable tomato = new Tomato();
        Basket<Fruit> fruitBasket = new Basket<>();
        Basket<Vegetable> vegetableBasket = new Basket<>();

        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(tomato);

        fruitBasket.makeSalad();
        vegetableBasket.makeSalad();
    }
}
