import fruits.Apple;
import fruits.Banana;
import fruits.Plant;
import vegetables.Cucumber;
import vegetables.Tomato;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Apple());
        plants.add(new Banana());
        plants.add(new Cucumber());
        plants.add(new Tomato());

        HashMap<String, Plant> map = new HashMap<>();
        plants.forEach(p -> map.put(p.getName(), p));

        map.forEach((name, plant) -> System.out.println(name + " " + plant.getClass().getSimpleName()));
    }
}
