import java.util.Arrays;
import java.util.Comparator;

public class QueueTwo implements Queue {
    private Integer[] array = new Integer[10];
    private int firstElement = 0;
    private int lastElement = 0;

    @Override
    public void add(int value) {
        for (int i = lastElement - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = value;
        lastElement++;
    }

    @Override
    public int remove() {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < lastElement; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        for (int i = minIndex + 1; i < lastElement; i++) {
            array[i - 1] = array[i];
        }
        lastElement--;
        return min;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == lastElement;
    }

    @Override
    public void sort(Swap method) {
        Comparator<Integer> comparator = (a, b) -> {
            if (method.needToSwap(a, b)) {
                return -1;
            }
            return 1;
        };
        Arrays.sort(array, firstElement, lastElement, comparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = firstElement; i < lastElement; i++) {
            sb.append(array[i]);
            if (i != lastElement - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
