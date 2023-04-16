package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private static class Node<T> {
        private Node prev;
        private T item;
        private Node next;

        private Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node<T>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /*
        1.
         __________              ___________
        | sentinel | ========>  |   first   |
        |__________| <========  |___________|

        2.
                      _________
             T-------| newNode | -----T
             |       |_________|      |
         ____V_____              _____V_____
        | sentinel | ========>  |   first   |
        |__________| <========  |___________|

        3.
                      _________
             T-------| newNode | ------T
             | T---->|_________| <---T |
         ____V_|___              ____|_V____
        | sentinel | ===xxx==>  |   first   |
        |__________| <==xxx===  |___________|
     */
    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(sentinel.prev, item, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
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
        Node p = sentinel;

        while (p.next != sentinel) {
            System.out.println(p.next.item + "\t");
            p = p.next;
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

        T item = (T) sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
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

        T item = (T) sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }

        Node p = sentinel.next;
        while (index-- > 0) {
            p = p.next;
        }
        return (T) p.item;
    }

    public T getRecursive(int index) {
        return get(index);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {

        Node p = sentinel.next;

        private LinkedListDequeIterator() {

        }

        @Override
        public boolean hasNext() {
            return p != sentinel;
        }

        @Override
        public T next() {
            Node<T> current = p;
            p = p.next;
            return current.item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Deque)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        Deque<T> oL = (Deque<T>) o;
        if (size != oL.size()) {
            return false;
        }

        Node p = sentinel.next;
        int i = 0;
        while (p != sentinel) {
            if (!p.item.equals(oL.get(i++))) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
