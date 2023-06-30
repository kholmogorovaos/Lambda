package elements.basic;

import elements.derived.Lava;
import elements.derived.Steam;

public class Fire extends NatureElement {
    @Override
    public NatureElement connect(NatureElement elem) {
        if (elem instanceof Air) {
            System.out.println("Fire + Air = " + new Energy());
            return new Energy();
        } else if (elem instanceof Earth) {
            System.out.println("Fire + Earth = " + new Lava());
            return new Lava();
        } else if (elem instanceof Water) {
            System.out.println("Fire + Water = " + new Steam());
            return new Steam();
        } else if (elem instanceof Fire) {
            throw new UnsupportedOperationException("Не производит новый элемент");
        }else {
            throw new UnsupportedOperationException("Недействительное сочетание элементов");
        }
    }
}
