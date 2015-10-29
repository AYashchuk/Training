package Homework4.threads;

/**
 * Created by admin on 25.11.2014.
 */
public class HolderTest {
    public static void main(String[] args) {
        Holder holder = Holder.getInstance();
        Consumer consumer = new Consumer(holder);
        Producer producer = new Producer(holder);
        consumer.start();
        producer.start();
    }
}
