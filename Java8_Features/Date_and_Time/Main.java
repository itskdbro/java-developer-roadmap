package Java8_Features.Date_and_Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // date
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // time
        LocalTime time = LocalTime.now();
        System.out.println(time);

        // Date and time together
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        // custom date
        LocalDate birthDate = LocalDate.of(2002, 12, 21);
        System.out.println("Birthday : " + birthDate);

        // Date plus
        LocalDate datePlus = date.plusDays(30);
        System.out.println("Date after 30 days will be : " + datePlus);

        LocalDate dateMinus = date.minusDays(15);
        System.out.println("Date before 15 days was : " + dateMinus);

    }
}
