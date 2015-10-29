package Homework4.threads;

/**
 * Created by admin on 18.11.2014.
 */
public class Holder {

    private static Holder instance = new Holder();
    private Holder(){

    }

    private Integer base = null;

    public boolean getEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    private boolean end =false;


    synchronized public void put(Integer valuse){
        boolean isPuted=false;
        while (!isPuted){
            if(base == null){
                base = valuse;
                isPuted = true;
            }else{
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }

    }


    synchronized  public  Integer get(){
        boolean isGeted=false;
        while (!isGeted){
            if(base != null){
               isGeted = true;
                Integer returnBase = new Integer(base);
                base=null;
               return returnBase;
            }else{
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }


    public static Holder getInstance(){
        return instance;
    }
}
