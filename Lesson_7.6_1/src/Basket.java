public class Basket <T> {
    private T[] items;

    public Basket() {
        this.items = (T[]) new Object[5];
    }
    public void addItem(T item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                System.out.println("Добавлен в корзину: " + item.getClass().getSimpleName());
                return;
            }
        }
        System.out.println("Корзина полная");
    }
}
