package elements.basic;

import elements.derived.Steam;

public class Energy extends NatureElement {
    @Override
    public NatureElement connect(NatureElement elem) {
        if (elem instanceof Water) {
            System.out.println("Energy + Water = " + new Steam());
            return new Steam();
        } else {
            throw new UnsupportedOperationException("Недействительное сочетание элементов");
        }
    }

    @Override
    public String toString() {
        return "Energy";
    }
}
