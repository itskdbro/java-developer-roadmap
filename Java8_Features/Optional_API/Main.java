package Java8_Features.Optional_API;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Optional<String> name = Optional.empty();
//        Optional<String> name = Optional.of("Keshav");
//        System.out.println(name.orElse("Tannu"));

//        String email = null;
//        Optional<String> nullOptional = Optional.ofNullable(email);
//        if(!nullOptional.isPresent()){
//            System.out.println("No Email");
//        }

//        Optional<Integer> age = Optional.of(24);
////        age.ifPresent(a -> System.out.println(a));
//        age.ifPresent(System.out::println);


//        Optional<String> name = Optional.of("Keshav");
//        name.map(value -> value.toUpperCase()).ifPresent(System.out::println);

//        Optional<String> city = Optional.of("Mumbai");
//        city.ifPresent(value -> System.out.println("City found"));

//        Optional<String> country = Optional.empty();
//        String c = country.orElseGet(() -> "india");
//        System.out.println(c);

        Optional<String> name = Optional.of("Rahul");
        name.filter(value -> value.startsWith("R")).ifPresent(System.out::println);

    }

}
