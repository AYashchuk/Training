package Thread.ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by admin on 17.11.2014.
 *
 * Пулл потоков
 * Есть 4 рабочих потоков, и один основной, основной принимает задачу (по интерфейсу Runnable) и
 * добавляет его в очередь задач (queue) дальше находит свободный поток и дает ему на выполнение задачу
 * если не находит, то ждет 1000 мс и опять ищет
 *
 * http://www.ibm.com/developerworks/ru/library/j-jtp0730/
 */

public class ThreadPool {
    boolean isWork = true;
    Queue<Runnable>  queue = new LinkedList();

    ArrayList<Worker> workers= new ArrayList <Worker>();

    public ThreadPool() {
        Worker worker_0 = new Worker("worker 0");
        Worker worker_1 = new Worker("worker 1");
        Worker worker_2 = new Worker("worker 2");
        Worker worker_3 = new Worker("worker 3");
        worker_0.start();
        worker_1.start();
        worker_2.start();
        worker_3.start();
        workers.add(worker_0);
        workers.add(worker_1);
        workers.add(worker_2);
        workers.add(worker_3);
    }

    public synchronized void submit (Runnable task) {
        if(task != null){
            queue.offer(task);
            do {
                for (int i = 0; i < workers.size(); i++) {
                    if (workers.get(i).isWorking() == false) {
                        workers.get(i).setTask(queue.poll());
                    }
                }
                if(isWork || !queue.isEmpty()){
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }while (!queue.isEmpty() && task != null);
        }

    }
}
