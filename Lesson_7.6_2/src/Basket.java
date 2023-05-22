import fruits.Plant;

import java.util.HashMap;
import java.util.Iterator;

public class Basket<T extends Plant> {
    private HashMap<T, Void> items = new HashMap<T, Void>();

    public void addItem(T item) {
        items.put(item, null);
    }

    public void makeSalad() {
        System.out.println("Готовим салатик:");
        for (T item : items.keySet()) {
            System.out.println("Режем - " + item.getName());
        }
        System.out.println("Угощайся!");
    }

    public Iterator<T> iterator() {
        return items.keySet().iterator();
    }
}
