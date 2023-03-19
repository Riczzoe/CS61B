package extend;

import java.util.Comparator;

public class Dog extends Bark implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Dog() {
        name = "dog";
        size = 1;
    }

    public void bark() {
        System.out.println("dag bark");
    }

    @Override
    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
