package Session3;

/**
 * Created by admin on 03.11.2014.
 */
public class MyThread implements Runnable{
    @Override
    public void run() {
        int i=0;
        while(!Thread.currentThread().isInterrupted()){ // isInterrupted() меняет значение булевской переменной в потоке на значение true
            i++;
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }

    }
}
