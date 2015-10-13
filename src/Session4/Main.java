package Session4;

/**
 * Created by admin on 04.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        ThreeTon t1 =   ThreeTon.getInstance();
        ThreeTon t2 =  ThreeTon.getInstance();
        ThreeTon t3 = ThreeTon.getInstance();
        System.out.println(t1.equals(t2));
        System.out.println(t2 == t3);
        ThreeTon t4  = ThreeTon.getInstance();

        System.out.println(t4 == t3);
        System.out.println(t4);


    }
}
