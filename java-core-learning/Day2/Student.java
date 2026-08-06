package Day2;

public class Student {
    String name;
    int age;
    String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;

    }

    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Course : " + course);
    }
}

