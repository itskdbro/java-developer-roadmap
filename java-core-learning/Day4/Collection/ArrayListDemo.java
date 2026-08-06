package Day4.Collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Spring boot");
        skills.add("SQL");
        skills.add("React");

        // Index based normal loop
//        for (int i = 0; i < skills.size(); i++) {
//            System.out.println(skills.get(i));
//        }

        System.out.println("Original List : ");
        // Enhanced for loop
        for (String skill : skills) {
            System.out.println(skill);
        }
        System.out.println("-------------------");

        skills.set(3, "Angular");
        skills.remove(2);
        System.out.println("Updated List : ");
        for (String skill : skills) {
            System.out.println(skill);
        }

        System.out.println("-------------------");


        boolean javaExtist = skills.contains("Java");
        System.out.println("Contains Java : " + javaExtist);
        System.out.println("Total Skills : " + skills.size());
    }
}
