package Homework3.hash;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by admin on 12.11.2014.
 */
public class HashMap<T> implements Iterable{
    private int SIZE=16;
    private LinkedList <Pair> Table   []= new LinkedList[SIZE];
    private int size;

    HashMap(){
        size=0;
        init();
    }

    private void init(){
        for(int i=0;i<Table.length;i++){
            if(Table[i] == null){
                Table[i] = new LinkedList<Pair>();
            }
        }
    }

    private void resize(){
        SIZE = SIZE*2;
        LinkedList <Pair> resizeTable   []= new LinkedList[SIZE];
        for(int i=0;i<Table.length;i++){
            if(Table[i].size() !=0){
                Pair thisPair = Table[i].get(0);
                int hashCode = thisPair.getKey()%SIZE;
                resizeTable[hashCode] = Table[i];
            }

        }
        Table = resizeTable;
        init();
    }


    public boolean put(int key, User value){
        key = Math.abs(key);                 // вдруг если ключь будет не коректный
        if((double) size/SIZE >= 0.75){
            resize();
        }
        int hashCode = key%SIZE;
        if(Table[hashCode].size() == 0){ //  если в таблице по данному индексу ещо нету значения,
            Table[hashCode].add(new Pair(key,value)); // то просто добавляем туда
            size++;
            return true;
        }else{                           // если же в таблице уже есть значение, то
            boolean isCreated = false;
            for(int i=0;i<Table[hashCode].size();i++){  // проходимся по связаному списку и проверяем ключи
                if(Table[hashCode].get(i).getKey() == key ){ // если находим такой же ключь , то
                    if( Table[hashCode].get(i).getValue().equals(value)){
                        return false;  // если елемент идентичній, то возвращаем не добавляем его, а сразу false
                    }else{
                        Table[hashCode].get(i).setValue(value); // то просто мняем значение
                        System.out.println("sfdfs");
                        isCreated = true;                       // ставим флажок в положения что елемент уже существует
                    }
                }
            }
            if(!isCreated){                                // если же елемент не существует,
                Table[hashCode].add(new Pair(key,value));  // создаем новый елемент и добавляем его в связаный список
                size++;
                return true;
            }

        }
        return true;
    }

    public User get(int key){
        key = Math.abs(key);                 // вдруг если ключь будет не коректный
        int hashCode = key%SIZE;
        if(Table[hashCode].size() !=0){   // если в связаном списке нету юзеров
            if(Table[hashCode].size() !=1){   // если не один юзер, то
                for(int i=0;i<Table[hashCode].size();i++){ // пробегаем по связаному списку юзеров, и
                    if(Table[hashCode].get(i).getKey() == key){  // находим нужного по ключу
                        return (User) Table[hashCode].get(i).getValue();
                    }
                }
            }else return (User) Table[hashCode].get(0).getValue();    // если юзер всего один в связаном списке, то его и возвращаем

        }else return null; // если юзеров в связаном списке нету, то возвращаем null
        return null; // если в связаном списке есть несколько пользователей, но не один не подходит нам по ключу
        // то возвращаем null
    }

    public boolean remove(int key){
        key = Math.abs(key);                 // вдруг если ключь будет не коректный
        int hashCode = key%SIZE;
        if(Table[hashCode].size() !=0){   // если в связаном списке нету  юзеров
            if(Table[hashCode].size() !=1){   // если не один юзер, то
                for(int i=0;i<Table[hashCode].size();i++){ // пробегаем по связаному списку юзеров, и
                    if(Table[hashCode].get(i).getKey() == key){  // находим нужного по ключу
                        Table[hashCode].remove(i);              // удоляем
                        return true;
                    }
                }
            }else{ // если юзер всего один в связаном списке, то его и удоляем
                Table[hashCode].remove(0);
                size--;                       // поскольку юзер всего один, то уменьшаем на еденицу размер всей хештаблицы
                return true;
            }
        }else return false; // если юзеров в связаном списке нету,по данному хешиндексу то возвращаем false
        return false; // если в связаном списке есть несколько пользователей по данному хешиндексу, но не один не подходит нам по ключу
        // то возвращаем null
    }
    public int size(){
        return this.size;
    }

    private class Pair <User>{
        private int Key;
        private User Value;

        public User getValue() {
            return Value;
        }

        public void setValue(User value) {
            Value = value;
        }

        public int getKey() {
            return Key;
        }

        Pair(int key, User value) {
            this.Key = key;
            this.Value = value;
        }
        @Override
        public String toString(){
            return "Key = " + Key+ ", {" +Value.toString()+"}";
        }
    }


    @Override
    public String toString(){
        return Arrays.toString(Table);
    }





    public Iterator iterator () {

        return new MyIterator();
    }





















    private class MyIterator <E> implements Iterator {

        private int index;  // индекс кооторый сравнивается с реальным
        private int thisIndex; // индекс на котором остановился метод hasNext()
        private int thisIndexLength;
        int oldSize = size;
        private int indexForRemove=0;


        public MyIterator() {
            index  = 0;       // индекс сравнюется с количеством елементов таблице
            thisIndex =0;     // текущий индекс который уже был взят с таблицы проходит по масиву Table
            thisIndexLength=0;// если по текущему индексу было несколько елементов (есть повторения в списке) етот индекс указывает на каком повторении остановился итератор
            // проходит по елементом линкед листа который хранится в Table[thisIndex]


        }

        @Override
        public boolean hasNext() {
           // index++;
            indexForRemove++;
            if(indexForRemove != index){
               return indexForRemove<= size;
            }
            return index < size ;   // если есто ещо что возвращать,
        }

        @Override
        public E next() {
            Pair somePair;
            if (index <= size) {                            // если итератор ещо не вернул все елементы масива
                if(thisIndexLength==0){                    // в линкед листе нету следущего елемента, то
                    for(;thisIndex<Table.length;){         // проходим по таблице (Table)
                        somePair = cheackLinkedListOnThisIterretion(); // проверяем линкид лист в данной позиции
                        if(somePair!=null){
                            index++;                                       // уведомляем счетчик количества полученых елементов на один
                            // System.out.println(thisIndex);
                            return (E) somePair.getValue();
                        }
                    }
                }else{
                       somePair=cheackLinkedListOnThisIterretion();   // проверяем линкид лист в данной позиции
                       if(somePair!=null){
                            index++;                                       // уведомляем счетчик количества полученых елементов на один
                            return (E) somePair.getValue();
                       }
                }
            } else throw new NoSuchElementException();


            return null;
        }















        @Override
        public void remove() {
            int key = nextKey();
            System.out.println(key);
            if(key != -1) {
                int hashCode = key%SIZE;
                if(Table[hashCode].size() !=0){   // если в связаном списке нету  юзеров
                    if(Table[hashCode].size() !=1){   // если не один юзер, то
                        for(int i=0;i<Table[hashCode].size();i++){ // пробегаем по связаному списку юзеров, и
                            if(Table[hashCode].get(i).getKey() == key){  // находим нужного по ключу
                                System.out.println("remove");
                                Table[hashCode].remove(i);              // удоляем

                            }
                        }
                    }else{ // если юзер всего один в связаном списке, то его и удоляем
                        Table[hashCode].remove(0);
                        // size--;                       // поскольку юзер всего один, то уменьшаем на еденицу размер всей хештаблицы
                    }
                }
                // то возвращаем null
            }

        }


        private Pair cheackLinkedListOnThisIterretion(){
            Pair thisPair=null;
            if(Table[thisIndex].size() != 0){                     // если нсвязаный список не пустой
                thisPair = Table[thisIndex].get(thisIndexLength); // берем с него текущей елемент
            }
            if((thisIndexLength+1) >= Table[thisIndex].size()){ // проверяем если в линкед листе нету следущего елемент, то
                thisIndex++;                                    // увел. счетчик таб. на 1
                thisIndexLength=0;                              // обнуляем счетчик линкед листв
            }else thisIndexLength++;   //  увеличиваем счетчик
            // System.out.println("не обнулен" + thisIndexLength);
            return thisPair;
        }



        public int nextKey() {
            int oldIndex=indexForRemove;  // индекс кооторый сравнивается с реальным
            int oldThisIndex = thisIndex; // индекс на котором остановился метод hasNext()
            int oldThisIndexLength=thisIndexLength;
            int oldSize = size;
            Pair somePair;
            if (oldIndex <= oldSize) {                            // если итератор ещо не вернул все елементы масива
                if(oldThisIndexLength==0){                       // в линкед листе нету следущего елемента, то
                    for(;oldThisIndex<Table.length;){            // проходим по таблице (Table)
                        somePair = cheackLinkedListOnThisIterretion(); // проверяем линкид лист в данной позиции
                        if(somePair!=null){
                            oldIndex++;                                       // уведомляем счетчик количества полученых елементов на один
                            // System.out.println(thisIndex);
                            return  somePair.getKey();
                        }
                    }
                }else{
                    somePair=cheackLinkedListOnThisIterretion();   // проверяем линкид лист в данной позиции
                    if(somePair!=null){
                        oldIndex++;                                       // уведомляем счетчик количества полученых елементов на один
                        return somePair.getKey();
                    }
                }
            }

            return -1;
        }



    }


}
