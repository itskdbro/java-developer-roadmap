package Day5.SetInterface;

import java.security.PublicKey;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> skills = new HashSet<>();

        skills.add("Java");
        skills.add("Spring boot");
        skills.add("SQL");
        skills.add("Java");
        skills.add("React");
        skills.add("SQL");

        System.out.println("All skills : ");
        for (String skill : skills) {
            System.out.println(skill);
        }
        System.out.println("-------------------");

        boolean ifContains = skills.contains("Java");
        if (ifContains) {
            System.out.println("Contains Java");
        } else {
            System.out.println("Doesn't contain java");
        }

        System.out.println("-------------------");
        System.out.println("Total Skills : " + skills.size());
        System.out.println("-------------------");

        skills.remove("React");
        System.out.println("Updated skills : ");
        for (String skill : skills) {
            System.out.println(skill);
        }
        System.out.println("-------------------");


    }
}
