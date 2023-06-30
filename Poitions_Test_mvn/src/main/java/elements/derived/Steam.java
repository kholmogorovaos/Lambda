package elements.derived;

import elements.basic.NatureElement;

public class Steam extends NatureElement {

    @Override
    public NatureElement connect(NatureElement elem) {
        throw new UnsupportedOperationException("Недействительное сочетание элементов");
    }

    @Override
    public String toString() {
        return "Steam";
    }
}
