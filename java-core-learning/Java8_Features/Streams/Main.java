package Java8_Features.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Aman", "Keshav", "Rohit", "Ankit", "Priya");
//        List<Integer> numbers = Arrays.asList(2, 5, 8, 10, 15, 20);

        // without Streams
//        for (String name : names) {
//            if (name.startsWith("A")) {
//                System.out.println(name);
//            }
//        }

        // With Streams
//        names.stream()
//                .filter(name -> name.startsWith("A"))
//                .forEach(name -> System.out.println(name));
//
//        numbers.stream()
//                .filter(number -> number % 2 == 0)
//                .forEach(System.out::println);

//        names.stream()
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

//        List<Integer> evenNumbers = numbers.stream()
//                .filter(number -> number % 2 == 0)
//                .map(number -> number * 2)
//                .collect(Collectors.toList());
//        System.out.println(evenNumbers);
//
//        List<Integer> numbers2 =
//                Arrays.asList(5, 10, 15, 20, 25, 30);
//
//        List<Integer> result = numbers2.stream()
//                .filter(number -> number > 15)
//                .map(number -> number * 2)
//                .collect(Collectors.toList());
//        System.out.println(result);

//        names.stream()
//                .sorted()  // ascending order
//                .sorted(Comparator.reverseOrder())  // descending order
//                .forEach(System.out::println);

//        List<String> cities = Arrays.asList(
//                "Delhi",
//                "Mumbai",
//                "Delhi",
//                "Pune",
//                "Mumbai",
//                "Jaipur"
//        );
//        List<String> distinctCities = cities.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinctCities);
//
//        List<Integer> numbers3 = Arrays.asList(5, 2, 8, 2, 10, 5, 12, 8);
//        List<Integer> result = numbers3.stream().distinct().sorted().collect(Collectors.toList());
//        System.out.println(result);

//        List<String> names4 = Arrays.asList("Aman", "Rahul", "Ankit", "Ajay", "Keshav");
//        long count = names4.stream()
//                .filter(name -> name.startsWith("A")).count();
//        System.out.println(count);

//        List<Integer> numbers = Arrays.asList(5, 10, 15, 20);
//        int sum = numbers.stream().reduce(0, Integer::sum);
//        System.out.println(sum);

        List<Integer> numbers = Arrays.asList(15, 40, 8, 100, 25);
        int max = numbers.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println(max);


    }


}
