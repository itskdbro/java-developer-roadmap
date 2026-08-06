package Java8_Features.DefaultMethods;

public interface Vehicle {
    public void start();
    default void stop(){
        System.out.println("Stopped.....");
    }
}
