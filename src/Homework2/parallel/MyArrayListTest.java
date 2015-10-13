package Homework2.parallel;


import java.util.ArrayList;

/**
 * Created by admin on 10.11.2014.
 */
public class MyArrayListTest {
    public static void init(MyArrayList<Integer>a){
        for(int i=0;i<20001;i++){
            int res =  (int) (Math.random()*1000000);
       //     System.out.println(res);
            a.add(res);
        }

    }

    public static void main(String[] args) {

        MyArrayList<Integer> array = new MyArrayList<Integer>();
        init(array);
        array.set(array.size()-1,-1);
        int index = array.parallelIndexOf(-1);
        System.out.println( "Елемент номер: "+index);
        System.out.println("Значение елемента: "+  array.get(index));
      //  System.out.println(array);
    }

}
