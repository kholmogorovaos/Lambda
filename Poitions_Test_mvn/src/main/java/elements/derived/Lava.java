package elements.derived;

import elements.basic.NatureElement;

public class Lava extends NatureElement {
    @Override
    public NatureElement connect(NatureElement elem) {
        throw new UnsupportedOperationException("Недействительное сочетание элементов");
    }

    @Override
    public String toString() {
        return "Lava";
    }
}
