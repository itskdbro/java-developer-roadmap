package Day6.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> employee = new HashMap<>();

        employee.put(101, "Keshav");
        employee.put(102, "Rahul");
        employee.put(103, "Aman");
        employee.put(104, "Priya");

        System.out.println("Employee List : ");
        for (Map.Entry<Integer, String> entry : employee.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("-------------------");


        System.out.println("Employee found : " + employee.get(103));
        System.out.println("-------------------");

        employee.put(102, "Rohan");

        System.out.println("Employee ID 105 exists : " + employee.containsKey(105));
        System.out.println("Employee name Keshav exists : " + employee.containsValue("Keshav"));
        employee.remove(104);
        System.out.println("-------------------");

        System.out.println("Total employees : " + employee.size());
        System.out.println("-------------------");
        System.out.println("Updated employee List : ");
        for (Map.Entry<Integer, String> entry : employee.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("-------------------");

        // challenge
        System.out.println(employee.keySet());
        System.out.println(employee.values());
        System.out.println(employee.entrySet());

    }
}
