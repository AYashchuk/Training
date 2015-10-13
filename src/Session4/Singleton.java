package Session4;

/**
 * Created by admin on 04.11.2014.
 */

/*        ленивый вариант

public class Singleton {

    private static Singleton instance ;
    private Singleton(){

    }
    public synchronized static Singleton getInstance(){
    if(instance == null){
    instance = new Singleton();
    }
        return instance;
    }
}




*/



public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
}
