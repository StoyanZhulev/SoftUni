package Lab10_AsynchronousProgramming;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        };


        Thread thread = new Thread(task);

        thread.start();

        thread.join();

        System.exit(1);
    }
}
