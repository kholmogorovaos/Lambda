public class Main {
    public static void main(String[] args) {
        Queue queueOne = new QueueOne();
        Queue queueTwo = new QueueTwo();

        for (String arg : args) {
            int val = Integer.parseInt(arg);
            queueOne.add(val);
            queueTwo.add(val);
        }
        queueOne.sort((a, b) -> a > b);
        System.out.println("Очередь 1, сортировка по возрастанию: " + queueOne);

        queueTwo.sort((a, b) -> a < b);
        System.out.println("Очередь 2, сортировка по убыванию: " + queueTwo + "\n");

        System.out.println("Очередь 1: " + "\n" + "Добавленные элементы: " + queueOne);
        while (!queueOne.isEmpty()) {
            System.out.println("Удален элемент: " + queueOne.remove() + ", оставшиеся элементы: " + queueOne);
        }
        System.out.println("элементы отсутствуют" + "\n");
        System.out.println("Очередь 2:");
        System.out.println("Добавленные элементы: " + queueTwo);
        while (!queueTwo.isEmpty()) {
            System.out.println("Удален элемент: " + queueTwo.remove() + ", оставшиеся элементы: " + queueTwo);
        }
        System.out.println("элементы отсутствуют");

    }
}
