package Session5.Hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by admin on 10.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        HashSet<Persen > array = new HashSet<Persen>();
        Persen user1 = new Persen("Lena","Pavlovna","Belykova",200,23);
        Persen user2 = new Persen("Sergey","Yrivich","Belyakov",200,23);
        Persen user3 = new Persen("Sergey","Yrivich","Belyakov",200,23);
        Persen user4  = new Persen("Andrey","Fedorovich","Yashchuk",200,23);
        array.add(user1);
        array.add(user2);
        System.out.println(array.add(user3));
        System.out.println(array.add(user4));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());
        System.out.println(user4.hashCode());
        System.out.println(array);

    }
}
