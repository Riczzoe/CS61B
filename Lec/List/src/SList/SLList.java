package SList;

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

    private IntNode sentFront;
    private int size;
    private IntNode sentBack;

    public SLList(int x) {
        sentFront = new IntNode(x, null);
        sentFront.next = new IntNode(x, null);
        sentBack = sentFront.next;
        size = 1;
    }

    public SLList() {
        sentFront = new IntNode(63, null);
        sentBack = sentFront.next;
        size = 0;
    }

    public void addFirst(int x) {
        sentFront.next = new IntNode(x, sentFront.next);
        size++;
    }

    public int getFirst() {
        return sentFront.next.item;
    }

    public void addLast(int x) {
        sentBack.next = new IntNode(x, null);
        sentBack = sentBack.next;
        size++;
    }

    public int size() {
        return size;
    }
}
