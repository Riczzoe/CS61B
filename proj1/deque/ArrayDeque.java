package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private static int DEFAULT_CAPACITY = 50;
    private T[] items;
    private int firstIndex;

    public ArrayDeque() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
        firstIndex = 0;
    }

    private int size;
    private int capacity;

    private void resize(int newSize) {
        T[] newItems = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(firstIndex + i) % capacity];
        }
        firstIndex = 0;
        capacity = newSize;
        items = newItems;
    }

    @Override
    public void addFirst(T item) {
        if (size == capacity) {
            resize(2 * size);
        }

        firstIndex = (firstIndex - 1 + capacity) % capacity;
        items[firstIndex] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == capacity) {
            resize(2 * size);
        }

        items[(firstIndex + size) % capacity] = item;
        size++;
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last.
     */
    @Override
    public void printDeque() {
        for (T item : items) {
            System.out.println(item + "\t");
        }
    }

    /**
     *  Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        T first = items[firstIndex++];
        firstIndex %= capacity;
        size--;
        return first;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        T last = items[(firstIndex + size-- - 1) % capacity];
        return last;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(firstIndex + index) % capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {

        private int pos;

        private ArrayDequeIterator() {
            pos = firstIndex;
        }

        @Override
        public boolean hasNext() {
            return pos - firstIndex < size;
        }

        @Override
        public T next() {
            return items[pos++ % capacity];
        }
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        ArrayDeque<T> op = (ArrayDeque<T>) o;
        if (size != op.size()) {
            return false;
        }
        for (int i = 0; i < size;) {
            if (!items[i].equals(op.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
