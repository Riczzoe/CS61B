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

}
