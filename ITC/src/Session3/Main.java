package Session3;

/**
 * Created by admin on 03.11.2014.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new MyThread());
        th.start();
        Thread.sleep(10);
        th.interrupt();
    }
}
