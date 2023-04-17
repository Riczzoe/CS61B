import java.util.*;
public class IteratorOfIterators implements <List<Iterator<Integer>>> {
    private List<Iterator<Integer>> iteratorLists;
    private int currentIndex;
    private int listSize;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        IteratorOfIterators = a;
        currentIndex = 0;
        listSize = a.size();
    }

    @Override
    public boolean hasNext() {
        int times = 0;
        while (times < listSize) {
            if (iteratorLists.get(currentIndex % listSize).hasNext()) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Integer next() {
        return iteratorLists.get(currentIndex % size).next();
    }
}
