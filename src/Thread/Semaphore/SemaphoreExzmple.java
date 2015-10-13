package Thread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by admin on 08.05.2015.
 *
 * Cемафоры используются для того, чтоб перед использованием ресурса проверить его доступность.
 Примером из жизни может служить тележка (общий ресурс) и два работника (потоки java). Один работник, к примеру,
 наполняет тележку песком. В это время второй работник, который перевозит груз и затем разгружает, не может взять тележку и отвезти ее.
 В то же время, если второй работник увез тележку, то первый работник не должен ничего наполнять.
 Ниже приведен небольшой пример программы из 3 классов.
 */
public class SemaphoreExzmple {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Worker worker1 = new Worker(semaphore, "Adder", true);
        Worker worker2 =  new Worker(semaphore, "Reducer", false);
        worker1.start();
        worker2.start();
/*        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
