package com.fruitbase;

import com.fruitbase.fruits.Fruit;

import java.io.*;

public class FruitBase implements Serializable {
    private static final long serialVersionUID = 1L;
    FruitCatalogue fruitCatalogue;

    FruitBase() {
        this.fruitCatalogue = new FruitCatalogue();
    }

    public Delivery takeOrder(String[] orderFruits) {
        Cargo cargo = new Cargo();
        for (String orderFruit : orderFruits) {
            Fruit f = fruitCatalogue.findFruit(orderFruit);
            if (f != null) {
                cargo.addFruit(f);
                System.out.println(f.getName());
            }
        }
        return cargo;
    }

    public void exportCatalogue(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(fruitCatalogue);
            out.close();
            fileOut.close();
            System.out.println("Каталог экспортирован " + fileName);
            System.out.println(fruitCatalogue); //для проверки значений
        } catch (FileNotFoundException e) {
            System.err.println("Не найден файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при экспорте каталога в файл " + fileName);
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка при экспорте каталога из файла " + fileName);
        }
    }

    public void importCatalogue(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            fruitCatalogue = (FruitCatalogue) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Каталог импортирован из файла: " + fileName);
            System.out.println(fruitCatalogue); //для проверки значений
        } catch (FileNotFoundException e) {
            System.err.println("Не найден файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при импорте каталога из файла " + fileName);
        } catch (ClassNotFoundException e) {
            System.err.println("Невозможно импортировать каталог из файла " + fileName + ": неподдерживаемая версия");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка при импорте каталога из файла " + fileName);
        }
    }
}

