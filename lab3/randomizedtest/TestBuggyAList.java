package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> list = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int randNum = random.nextInt();
            list.addLast(randNum);
            buggyAList.addLast(randNum);
        }

        assertEquals(buggyAList.size(), list.size());

        assertEquals(buggyAList.removeLast(), list.removeLast());
        assertEquals(buggyAList.removeLast(), list.removeLast());
        assertEquals(buggyAList.removeLast(), list.removeLast());
        assertEquals(buggyAList.removeLast(), list.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
                System.out.println("L           addLast(" + randVal + ")");
                System.out.println("buggyList   addLast(" + randVal + ")");
                System.out.println();
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("L           size: " + size);
                System.out.println("buggyList   size: " + buggyAList.size());
                System.out.println();
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    System.out.println("L           getLast(" + L.getLast() + ")");
                } else {
                    System.out.println("L           size == 0!!!!!!!!!!!!!!!!!!"  );
                }

                if (buggyAList.size() > 0) {
                    System.out.println("buggyList   getLast(" + buggyAList.getLast() + ")");
                } else {
                    System.out.println("buggyList   size == 0!!!!!!!!!!!!!!!!!!"  );
                }

                System.out.println();
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    System.out.println("L           removeLast(" + L.removeLast() + ")");
                } else {
                    System.out.println("L           size == 0!!!!!!!!!!!!!!!!!!"  );
                }

                if (buggyAList.size() > 0) {
                    System.out.println("buggyList   removeLast(" + buggyAList.removeLast() + ")");
                } else {
                    System.out.println("buggyList   size == 0!!!!!!!!!!!!!!!!!!"  );
                }

                System.out.println();
            }
        }
    }
}
