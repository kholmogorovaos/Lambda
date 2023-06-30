package alchemy;

import elements.basic.NatureElement;

import java.util.NoSuchElementException;

public class Alchemy {
    public static void main(String[] args) {
        if (args.length == 0 || args.length % 2 != 0) {
            System.out.println("Неверное количество аргументов");
            return;
        }
        connectElements(createNatureElements(args));
    }

    public static NatureElement[] createNatureElements(String[] args) {
        NatureElement[] elems = new NatureElement[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                elems[i] = NatureElement.create(args[i]);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        return elems;
    }

    public static NatureElement[] connectElements(NatureElement[] elems) {
        NatureElement[] result = new NatureElement[elems.length / 2];
        int j = 0;
        for (int i = 0; i < elems.length-1; i += 2) {
            try {
                NatureElement connected = elems[i].connect(elems[i + 1]);
                if (connected != null) {
                    result[j++] = connected;
                }
            } catch (UnsupportedOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

}


