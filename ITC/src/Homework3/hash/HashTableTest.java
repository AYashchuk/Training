package Homework3.hash;

import java.util.Iterator;

/**
 * Created by admin on 12.11.2014.
 */
 public class HashTableTest {
    public static void main(String[] args) {
        User user1 = new User("Dimon_0","134441","18.12.1995",12,false);
        User user4 = new User("Dimon","1111","18.12.1994",12,false);
        User user3 = new User("Pasha","1423521","3.11.1992",110,true);
        User user2 = new User("Dimon","134441","18.12.1995",12,false);
        HashMap<User> table = new HashMap<User>();

        for(int i=0;i<8;i++){
            table.put(i,new User("Dimon"+i,"134441","18.12.1995",12,false));
        }

        //   System.out.println(table.remove(-1));



         // System.out.println(table.put(8, user1));
       /* System.out.println(table);
         System.out.println(table.remove(32));
        System.out.println(table);
        System.out.println(table.remove(32));
      //  System.out.println(table.get(48));
       // System.out.println(table.put(, user4));
        /*
        System.out.println(table.put(1, user1));
        System.out.println(table.put(33, user2));

*/      System.out.println(table);
        Iterator<User> iter = table.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        /*while(iter.hasNext()) {
            iter.remove();
        }*/
        System.out.println(table);
    }
}
