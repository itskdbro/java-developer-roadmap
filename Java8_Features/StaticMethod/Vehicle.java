package Java8_Features.StaticMethod;

public interface Vehicle {
    public void start();
    static void stop(){
        System.out.println("Stopped.....");
    }
}
