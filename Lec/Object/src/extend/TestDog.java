package extend;

public class TestDog {
    public static void main(String[] args) {
        Object o2 = new showDog();

        showDog sdx = (showDog) o2;
        sdx.bark();

        Dog dx = ((Dog) o2);
        dx.bark();

        ((Dog) o2).bark();

        Object o3 = (Dog) o2;
    }
}
