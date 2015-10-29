package Thread.Semaphore;

/**
 * Created by admin on 08.05.2015.
 */
public class Cart {
    private static int weight = 0;

    public static void addWeight(){
        weight--;
    }

    public static void reduceWeight(){
        weight++;
    }

    public static int getWaight(){
        return weight;
    }
}
