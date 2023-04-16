package flik;

import static org.junit.Assert.assertTrue;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i;
        for (i = 0; i < 500; ++i) {
            assertTrue(String.format("i:%d not same as j:%d ??", i, i), Flik.isSameNumber(i, i));
        }
        System.out.println("i is " + i);
    }
}
