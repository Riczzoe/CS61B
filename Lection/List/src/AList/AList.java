package AList;

public class AList {
    private int size;
    private int[] items;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = new int[100];
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size >= items.length) {
            resizeItems(size * 2);
        }
        items[size] = x;
        size++;
    }

    private void resizeItems(int newSize) {
        int[] temp = new int[newSize];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return size > 0 ? items[size - 1] : -1;
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return i <= size - 1 ? items[i] : -1;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        if (size < 1) {
            return -1;
        }
        if (1.0 * size / items.length < 0.25) {
            resizeItems(items.length / 2);
        }
        size--;
        return items[size];
    }
}
