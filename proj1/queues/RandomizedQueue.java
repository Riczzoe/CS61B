package queues;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private static int DEFAULT_CAPACITY = 50;
    private Item[] items;
    private int firstIndex;

    public RandomizedQueue() {
        items = (Item[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
        firstIndex = 0;
    }

    private int size;
    private int capacity;

    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(firstIndex + i) % capacity];
        }
        firstIndex = 0;
        capacity = newSize;
        items = newItems;
    }

    public void addFirst(Item item) {
        if (size == capacity) {
            resize(2 * size);
        }

        firstIndex = (firstIndex - 1 + capacity) % capacity;
        items[firstIndex] = item;
        size++;
    }

    public void addLast(Item item) {
        if (size == capacity) {
            resize(2 * size);
        }

        items[(firstIndex + size) % capacity] = item;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last.
     */
    public void printDeque() {
        for (Item item : items) {
            System.out.println(item + "\t");
        }
    }

    /**
     *  Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        Item first = items[firstIndex++];
        firstIndex %= capacity;
        size--;
        return first;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        Item last = items[(firstIndex++ + size--) % capacity];
        firstIndex %= capacity;
        return last;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     */
    public Item get(int index) {
        if (index < firstIndex || index >= firstIndex + size) {
            return null;
        }
        return items[index];
    }

    public Item getRecursive(int index) {
        return get(index);
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public boolean equals(Object o) {
        if (!(o instanceof RandomizedQueue)) {
            return false;
        }
        RandomizedQueue<Item> op = (RandomizedQueue<Item>) o;
        if (size != op.size()) {
            return false;
        }
        for (int i = 0; i < size;) {
            if (items[i] != op.get(i)) {
                return false;
            }
        }
        return true;
    }


    private class RandomizedQueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
