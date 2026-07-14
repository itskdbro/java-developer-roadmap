package Day10_Multithreading;

public class Main {

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName()); // - Main Thread created by JVM

        // Thread Class
        MyThread t1 = new MyThread();
        t1.start();

        // Runnable interface
        MyThread2 t2 = new MyThread2();
        Thread thread = new Thread(t2);
//        thread.start();


        System.out.println("End of prog.");
    }
}
