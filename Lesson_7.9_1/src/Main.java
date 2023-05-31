import fruits.Apple;
import fruits.Banana;
import fruits.Fruit;
import fruits.Plant;
import vegetables.Cucumber;
import vegetables.Tomato;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Apple());
        plants.add(new Banana());
        plants.add(new Cucumber());
        plants.add(new Tomato());

        ArrayList<Fruit> multifruit = plants.stream()
                .filter(p -> p instanceof Fruit)
                .map(p -> (Fruit) p)
                .collect(Collectors.toCollection(ArrayList::new));
        multifruit.forEach(f -> System.out.println(f.getName()));
    }
}
