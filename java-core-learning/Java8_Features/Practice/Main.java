package Java8_Features.Practice;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 6, 2, 7, 9, 12, 15, 17);
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println );

        List<String> names = Arrays.asList("Keshav","Ravi","Aman","Anisha");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        Integer result = numbers.stream().distinct().reduce(0,Integer::sum);
        System.out.println(result);

        LocalDate today = LocalDate.now();
        System.out.println(today.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));

        Optional<String> name = Optional.empty();
        System.out.println(name.orElse("Guest"));


    }
}
