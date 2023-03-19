package extend;

import SList.SLList;

public class VengefulSLList<Item> extends SLList<Item> {
    private SLList<Item> deletedItems;

    public VengefulSLList() {
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item oldBack = removeLast();
        deletedItems.addLast(oldBack);
        return oldBack;
    }


}

