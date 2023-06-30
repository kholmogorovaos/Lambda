package elements.basic;

import java.util.NoSuchElementException;

abstract public class NatureElement {
    public NatureElement connect(NatureElement elem) {
        throw new UnsupportedOperationException("Недействительное сочетание элементов");
    }

    public static NatureElement create(String name) {
        switch (name.toLowerCase()) {
            case "fire":
                return new Fire();
            case "air":
                return new Air();
            case "earth":
                return new Earth();
            case "water":
                return new Water();
            case "energy":
                return new Energy();
            default:
                throw new NoSuchElementException("Неизвестный элемент: " + name);
        }
    }
}
