package Day4.Collection;

import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Jaipur");
        cities.add("Mumbai");

        System.out.println(cities);

        cities.addFirst("Noida");
        cities.addLast("Pune");
        System.out.println(cities);

        cities.removeFirst();
        System.out.println(cities);
    }
}
