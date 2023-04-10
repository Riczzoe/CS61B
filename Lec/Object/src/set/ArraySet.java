package set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                if (x == null)
                    return true;
                continue;
            }

            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. */
    public void add(T x) {
        if (contains(x)) {
            return;
        }
        items[size++] = x;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    // @Override
    // public String toString() {
    //     StringBuilder res = new StringBuilder("{");
    //     for (T t : this) {
    //         res.append(t);
    //         res.append(", ");
    //     }
    //     int lastCommaIndex = res.lastIndexOf(",");
    //     res = res.delete(lastCommaIndex, lastCommaIndex + 2);
    //     res.append("}");
    //     return res.toString();
    // }

    @Override
    public String toString() {
        ArrayList<String> listOfItems = new ArrayList<>();
        for (T s : this) {
            listOfItems.add(s == null ? "null" : s.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp ... stuff) {
        ArraySet<Glerp> res = new ArraySet<>();
        for (Glerp glerp : stuff) {
            res.add(glerp);
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof ArraySet s) {
            if (size != s.size) {
                return false;
            }

            for (T t : this) {
                if (!s.contains(t)) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            this.wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            return items[wizPos++];
        }
    }

    public static void main(String[] args) {
        ArraySet<String> as = new ArraySet<>();
        as.add("horse");
        as.add("fish");
        as.add("fish");
        as.add(null);
        as.add("dog");
        System.out.println(as.contains("dog"));
        System.out.println(as.contains(null));

        System.out.println(as);

        ArraySet<Integer> of = ArraySet.of(1, 2, 3, 4, 5);
        System.out.println("of = " + of);

    }
}
