package Homework4.threads;

/**
 * Created by admin on 25.11.2014.
 */
public class Consumer extends Thread{
    private Holder holder;

    Consumer(Holder holder){
        this.holder = holder;
    }


    @Override
    public void run(){
        while (!holder.getEnd()){
            System.out.println("Consumer get: "+holder.get());
        }
        System.out.println("end");

    }

}
