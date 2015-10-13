package Homework4.threads;

/**
 * Created by admin on 25.11.2014.
 */
public class Producer extends Thread{
    private Holder holder;

    Producer(Holder holder){
        this.holder = holder;
    }

    @Override
    public void run(){
        for(int i=0;i<30;i++){
            holder.put(new Integer(i));
            System.out.println("Producer put: " +i);
        }
        holder.setEnd(true);

    }
}
