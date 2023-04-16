package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }

        T max = get(0);
        for (T t : this) {
            if (comparator.compare(t, max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T max = get(0);
        for (T t : this) {
            if (c.compare(t, max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                }

                if (o1.intValue() < o2.intValue()) {
                    return -1;
                }
                return 1;
            }
        };

        MaxArrayDeque maxArrayDeque = new MaxArrayDeque(c);
        for (int i = 99; i >= 0; i--) {
            maxArrayDeque.addFirst(i);
            System.out.print(" " + i);
        }

        System.out.println(" " + maxArrayDeque.max());
        System.out.println(maxArrayDeque.max(c));

    }
}
