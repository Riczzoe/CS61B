package SList;

public class SLList<Item> {
    public class IntNode {
        public Item item;
        public IntNode next;
        public IntNode prev;

        public IntNode(Item item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentFront;
    private int size;
    private IntNode sentBack;

    public SLList(Item x) {
        sentFront = new IntNode(x, null);
        sentFront.next = new IntNode(x, null);
        sentBack = sentFront.next;
        size = 1;
    }

    public SLList() {
        sentFront = new IntNode(null, null);
        sentBack = sentFront.next;
        size = 0;
    }

    public void addFirst(Item x) {
        sentFront.next = new IntNode(x, sentFront.next);
        size++;
    }

    public Item getFirst() {
        return sentFront.next.item;
    }

    public void addLast(Item x) {
        sentBack.next = new IntNode(x, null);
        sentBack = sentBack.next;
        size++;
    }

    public Item removeLast() {
        return null;
    }

    public int size() {
        return size;
    }
}
