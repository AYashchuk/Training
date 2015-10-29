package Thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by admin on 05.05.2015.
 * Блокирующая опередь
 */
public class RunBlocking {


    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        new Thread(){
            @Override
            public void run(){
                for(int i = 1 ; i < 4; i++){
                    try {
                        queue.put("Java " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Element " + "Java " + i + " - added");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("Element " + queue.take() + " took");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
