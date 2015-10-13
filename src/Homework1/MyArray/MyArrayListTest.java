package Homework1.MyArray;

import Homework1.MyArray.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by admin on 29.10.2014.


  Hommwork_1_________________________________________________________________________________________________________

 * [28.10.2014 23:46:47] Александр (JAVA):
 * 1. Написать собственную реализацию класса Scanner, класс MyScanner, работающую с символьными потоками.
 Создать два конструктора в один передается объект по ссылке Reader, во второй String.

 Реализовать методы:

 String next() - чтение одного слова в строке
 int nextInt() - чтение целого числа из строки или InputMismatchException
 String nextLine() - чтение всей строки
 boolean hasNext() - определение наличия в потоке данных
 boolean hasNextInt() - определение наличия в потоке целого int числа
 useDelimiter(char) - использует разделитель
 close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException


  2. Написать собственную реализацию динамического массива MyArrayList,
 содержащего целые числа. Реализовать следующие методы
 - void add(int value)
 - int get(int index)
 - boolean set(int index, int value)
 - boolean add(int index, int value)
 - int indexOf(int value)
 - int size()
 - boolean remove(int index)


 3. Написать собственную реализацию динамического массива MyArrayList.
 Сделать параметризацию списка, параметр E.
 Реализовать в списке интерфейсы Iterable.
 Реализовать следующие методы
 - void add(E value)
 - int get(int index)
 - boolean set(int index, E value)
 - boolean add(int index, E value)
 - int indexOf(E value)
 - int size()
 - E remove(int index)
 - Iterator<E> iterator()



 4.  Написать приложение "Рабочее место кассира в супермаркете", класс Cashier. Оформить всё в виде одного класса.
 Реализовать следующие функции приложения в виде консольного меню:
 Авторизация по имени и паролю, метод boolean isAuthorized(String login, String password).
 Показать меню, метод void showMenu()
 Создать покупку, метод void createPurchase()
 Добавить в покупку товар по штрихкоду, указать кол-во единиц покупаемого товара, метод void addGoods(String barCode, int count)
 Убрать из покупки товар по штрихкоду, указать кол-во единиц покупаемого товара, метод void removeGoods(String barCode, int count)
 Отменить покупку, метод void cancelPurchase().
 Завершить покупку, на экран выводится общаяя сумма покупки, метод double closePurchase()

 */
public class MyArrayListTest {

    public static void dinamikInitial(MyArrayList array){
        for(int i=0; i< 10;i++){
            int value =  i+1;  //(int) (Math.random() * 100);
         //   int value =  3;
            array.add(value);
        }
    }

    public static void main(String[] args) {


/*
        ArrayList ar = new ArrayList();
        Iterator iter = ar.iterator();


        ar.add(1);
        iter.remove();
     ar.add(2);
        ar.add(3);
        ar.set(2,4);

            System.out.println(iter.next());

*/

      //System.out.println(ar.toString());



        MyArrayList <Integer> array = new MyArrayList <Integer>();
        Iterator iter  = array.iterator() ;



        // инициализируем масив
        dinamikInitial(array);
        // выводим на екран
        array.toString();
       /* // выводим его длину
        System.out.println("Size: " + array.size());
        // добавляем один елемент
        //array.add(11); // добавляю 11 елемент
        // выводим на екран
        array.toString();
        // выводим его длину
        System.out.println("Size: " + array.size());

        // выводим первый и последний елемент
        System.out.println("array[0] = "+array.get(0));
        System.out.println("array[length-1] = "+array.get(array.size()-1));







        // проверка добавления елементов
        System.out.println();
        // array.remove(4);
        array.add(10,0);
        array.toString();
        System.out.println("Size: " + array.size());
        // выводим первый и последний елемент
        System.out.println("array[0] = "+array.get(0));
        System.out.println("array[length-1] = "+array.get(array.size()-1));








        array.remove(2); // удоляю 3-тий елемент
        // выводим на екран
        array.toString();
        // выводим его длину
        System.out.println("Size: " + array.size());
        // выводим первый и последний елемент
        System.out.println("array[0] = "+array.get(0));
        System.out.println("array[length-1] = "+array.get(array.size()-1));
        array.set(2,3); // устанавливаю 3-тим елементом 3
        array.toString();
        // выводим его длину
        System.out.println("Size: " + array.size());
        // выводим первый и последний елемент
        System.out.println("array[0] = "+array.get(0));
        System.out.println("array[length-1] = "+array.get(array.size()-1));

        // находим елемент по индексу
        System.out.println(array.indexOf(1));
        System.out.println(array.indexOf(999));
        System.out.println(array.indexOf(0));






        System.out.println("\n***** testing Iterator ***********");

        Integer s = new Integer(3);
        System.out.println(iter.hasNext());

        iter.remove();
        iter.remove();
        */
/*
        while(iter.hasNext()){
             Integer value = (Integer)iter.next();
          //  System.out.println(value);
             if(value%3 == 0){
                 iter.remove();
                 System.out.println("remove:" + value);
             }

        }
*/


          array.toString();


    }
}
