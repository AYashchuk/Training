package Session2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by admin on 28.10.2014.
 * 1) Задание
 * написать метод удоляющий елементы кратные трем используя Iterator
 *
 *
 */



public class Main {
    public static void genereted(List list){
        for(int i=0; i < 10; i++){
            int value = (int)(Math.random()*100*i);
            list.add(value);
        }
    }


    public static void filter3(List list){
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            if(it.next()%3 == 0){
                it.remove();
            }
        }




    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        genereted(list);
        System.out.println(list.toString());
        filter3(list);
        System.out.println(list.toString());
    }
}
