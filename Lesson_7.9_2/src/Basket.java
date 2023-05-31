import vegetables.Cucumber;
import vegetables.Vegetable;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Vegetable, Integer> contents = new HashMap<>();

    public void addItem(Vegetable item, int quantity) {
        if (item instanceof Cucumber) {
            if (contents.containsKey(item)) {
                contents.put(item, contents.get(item) + quantity);
            } else {
                contents.put(item, quantity);
            }
        } else {
            contents.put(item, quantity);
        }
    }

    public int size() {
        return contents.values().stream().reduce(0, Integer::sum);
    }
}
