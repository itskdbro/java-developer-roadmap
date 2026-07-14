package Day10_Multithreading;

// Thread using Runnable interface
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread created using Runnable interface");
    }
}
