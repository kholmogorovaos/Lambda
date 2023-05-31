import vegetables.Cucumber;
import vegetables.Tomato;
import vegetables.Vegetable;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Vegetable cucumber = new Cucumber();
        Vegetable tomato = new Tomato();

        basket.addItem(cucumber, 1);
        basket.addItem(cucumber, 1);
        basket.addItem(cucumber, 1);

        basket.addItem(tomato, 1);
        basket.addItem(tomato, 1);

        System.out.println(basket.size());
    }
}
