package Day10_Multithreading;

// Thread using Thread Class
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread created using Thread Class");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
