package flik;

import org.junit.Test;

public class FlikTest {
    @Test
    public void test128() {
        Integer a = -1;
        Integer b = -1;
        System.out.println(a == b);
    }

    @Test
    public void testHS() throws Exception {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
    }
}
