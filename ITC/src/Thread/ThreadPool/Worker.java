package Thread.ThreadPool;

/**
 * Created by admin on 17.11.2014.
 */
public class Worker extends Thread {
    private boolean isWorking = false;
    private Runnable task;
    private String name;



    public Worker(String name){
        this.name = name;
    }


    public void setTask(Runnable task) {
        this.task = task;
        isWorking = true;
        notify();
    }

    private void doTask (){
        if(task == null){
            synchronized(this) {
                try {
                     wait(10000);
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        task.run();
        task = null;
        isWorking = false;
    }

    @Override
    public void run(){
        while (!isInterrupted()){
            doTask();
        }

    }


    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isWorking() {
        return isWorking;
    }
}
