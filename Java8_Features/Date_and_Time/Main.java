package Java8_Features.Date_and_Time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
//        // date
        LocalDate date = LocalDate.now();
//        System.out.println(date);
//
//        // time
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
//
//        // Date and time together
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
//
//        // custom date
//        LocalDate birthDate = LocalDate.of(2002, 12, 21);
//        System.out.println("Birthday : " + birthDate);
//
//        // Date plus
//        LocalDate datePlus = date.plusDays(30);
//        System.out.println("Date after 30 days will be : " + datePlus);
//
//        LocalDate dateMinus = date.minusDays(15);
//        System.out.println("Date before 15 days was : " + dateMinus);


//        LocalDate birthday = LocalDate.of(2002, 12, 21);
//        Period age = Period.between(birthday, date);
//        System.out.print("Your age is : ");
//        System.out.print(age.getYears() + " years ");
//        System.out.print(age.getMonths() + " months ");
//        System.out.print(age.getDays() + " days");

//        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        System.out.println(date.format(DateTimeFormatter.ofPattern("EEEE")));
//        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        System.out.println(date.format(DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy")));
//
//        LocalTime start = LocalTime.of(9, 30);
//        LocalTime end = LocalTime.of(18, 30);
//        Duration duration = Duration.between(start, end);
//        System.out.print(duration.toHours() + " Hours ");
//        System.out.print(duration.toMinutes() + " Minutes ");

//        String result = dateFormat(date);
//        System.out.println(result);
        ageCalculator("21-12-2002");


    }

    public static String dateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);

    }

    public static void ageCalculator(String date) {
        LocalDate dob = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate today = LocalDate.now();
        Period age = Period.between(dob, today);
        System.out.print("Age : " + age.getYears() + " years " + age.getMonths() + " months " + age.getDays() + " days");

    }
}
