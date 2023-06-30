package elements.derived;

import elements.basic.NatureElement;

public class Rain extends NatureElement {
    @Override
    public NatureElement connect(NatureElement elem) {
        throw new UnsupportedOperationException("Недействительное сочетание элементов");
    }

    @Override
    public String toString() {
        return "Rain";
    }
}
