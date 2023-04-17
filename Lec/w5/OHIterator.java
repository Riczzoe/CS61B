public class OHIterator implements Iterator<OHRequest> {
    private OHRequest curr;

    public OHIterator(OHRequest queue) {
        curr = queue;
    }

    public static boolean isGood(String description) { 
        return description.length() >= 5;
    }

    @Overrid
    public boolean hasNext() {
        while (curr != bull && !isGood(curr.description)) {
            curr = curr.next;
        }
        if (curr == null) {
            return false;
        }
        return true;
    }
    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest req = curr;
        curr = curr.next;
        return curr;
    }
}
