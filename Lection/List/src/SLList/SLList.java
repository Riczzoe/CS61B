package SLList;

public class SLList {

    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public SLList() {
        sentinel = new IntNode(-63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(-63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public static  int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size;
    }

    public void addLast(int x) {
        /* Too slow
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
        size++; */
        last.next = new IntNode(x, null);
        last = last.next;
        size++;
    }

    public static void main(String[] args) {
        SLList s = new SLList(3);
        s.addFirst(2);
        s.addFirst(1);
        s.addLast(4);
    }
}
