package extend;

import SList.SLList;

public class RotatingSLList<Blorp> extends SLList<Blorp> {
    public RotatingSLList() {

    }

    public void rotateRight() {
        Blorp oldBack = removeLast();
        addFirst(oldBack);
    }
}
